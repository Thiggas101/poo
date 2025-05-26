
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Partida {
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

        String resultadoT1 = getResultadoPara(time1);
        String resultadoT2 = getResultadoPara(time2);

        if (!resultadosPorTime.containsKey(time1)) {
            resultadosPorTime.put(time1, new ArrayList<>());
        }
        resultadosPorTime.get(time1).add(resultadoT1);

        if (!resultadosPorTime.containsKey(time2)) {
            resultadosPorTime.put(time2, new ArrayList<>());
        }
        resultadosPorTime.get(time2).add(resultadoT2);
    }

    public String getResultadoPara(Time time) {
        Time adversario = time.equals(time1) ? time2 : time1;
        boolean venceu = time.equals(vencedor);
        return " - " + adversario.getNome() + " - " + (venceu ? "Venceu" : "Perdeu");
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