import java.util.*;

public class Partida {
    private Time time1;
    private Time time2;
    private Time vencedor;
    private static List<Partida> historico = new ArrayList<>();
    private static Map<Time, List<String>> resultadosPorTime = new HashMap<>();

    public Partida(Time time1, Time time2, Time vencedor) {
        this.time1 = time1;
        this.time2 = time2;
        this.vencedor = vencedor;
    }

    public void registrarResultado() {
        vencedor.adicionarPontuacao(3);
        historico.add(this);

        Time perdedor = (vencedor == time1) ? time2 : time1;

        resultadosPorTime
            .computeIfAbsent(vencedor, k -> new ArrayList<>())
            .add(perdedor.getNome() + " - Venceu");

        resultadosPorTime
            .computeIfAbsent(perdedor, k -> new ArrayList<>())
            .add(vencedor.getNome() + " - Perdeu");
    }

    public Time getTime1() {
        return time1;
    }

    public Time getTime2() {
        return time2;
    }

    public Time getVencedor() {
        return vencedor;
    }

    public static List<Partida> getHistorico() {
        return historico;
    }

    public static List<String> getResultadosDoTime(Time time) {
        return resultadosPorTime.getOrDefault(time, new ArrayList<>());
    }
}
