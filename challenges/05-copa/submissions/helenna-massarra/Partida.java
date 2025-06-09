import java.util.ArrayList;
import java.util.Collections;
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
        if (vencedor != null) {
            vencedor.adicionarPontuacao(3);
        }

        historico.add(this);

        registrarResultadoParaTime(time1, vencedor == time1 ? "Venceu" : "Perdeu");
        registrarResultadoParaTime(time2, vencedor == time2 ? "Venceu" : "Perdeu");
    }

    private void registrarResultadoParaTime(Time time, String resultado) {
        resultadosPorTime.computeIfAbsent(time, k -> new ArrayList<>())
                         .add(getAdversario(time).getNome() + " - " + resultado);
    }

    public static List<Partida> getHistorico() {
        return historico;
    }

    public static List<String> getResultadosDoTime(Time time) {
        return resultadosPorTime.getOrDefault(time, Collections.emptyList());
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

    private Time getAdversario(Time time) {
        return (time == time1) ? time2 : time1;
    }
}
