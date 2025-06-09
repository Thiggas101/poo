import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if (vencedor == time1) {
            time1.adicionarPontuacao(3);
            adicionarResultado(time1, "Venceu", time2);
            adicionarResultado(time2, "Perdeu", time1);
        } else if (vencedor == time2) {
            time2.adicionarPontuacao(3);
            adicionarResultado(time2, "Venceu", time1);
            adicionarResultado(time1, "Perdeu", time2);
        }

        historico.add(this);
    }

    private void adicionarResultado(Time time, String resultado, Time adversario) {
        resultadosPorTime
            .computeIfAbsent(time, k -> new ArrayList<>())
            .add(adversario.getNome() + " - " + resultado);
    }

    public static List<Partida> getHistorico() {
        return historico;
    }

    public static List<String> getResultadosDoTime(Time time) {
        return resultadosPorTime.getOrDefault(time, new ArrayList<>());
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
}
