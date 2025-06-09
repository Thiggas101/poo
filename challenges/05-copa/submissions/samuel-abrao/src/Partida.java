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
        vencedor.adicionarPontuacao(3);
        historico.add(this);
        registrarResultadoPara(time1, time2);
        registrarResultadoPara(time2, time1);
    }

    private void registrarResultadoPara(Time principal, Time adversario) {
        String resultado = principal == vencedor ? "Venceu" : "Perdeu";
        String linha = adversario.getNome() + " - " + resultado;
        resultadosPorTime.computeIfAbsent(principal, k -> new ArrayList<>()).add(linha);
    }

    public List<String> getResultadoPara(Time time) {
        return resultadosPorTime.getOrDefault(time, new ArrayList<>());
    }

    public static List<Partida> getHistorico() {
        return historico;
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
