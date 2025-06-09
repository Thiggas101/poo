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
        registrarResultado();
    }

    private void registrarResultado() {
        vencedor.adicionarPontuacao(3);
        historico.add(this);

        registrarResultadoParaTime(time1, time1 == vencedor ? "Venceu" : "Perdeu", time2);
        registrarResultadoParaTime(time2, time2 == vencedor ? "Venceu" : "Perdeu", time1);
    }

    private void registrarResultadoParaTime(Time time, String resultado, Time adversario) {
        resultadosPorTime.computeIfAbsent(time, k -> new ArrayList<>())
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

    @Override
    public String toString() {
        return time1.getNome() + " vs " + time2.getNome() + " - Vencedor: " + vencedor.getNome();
    }
}
