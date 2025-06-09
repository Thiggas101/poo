import java.util.ArrayList;
import java.util.List;

public class Partida {
    private Time time1;
    private Time time2;
    private Time vencedor;
    private static List<Partida> historico = new ArrayList<>();
    //private Map<Time, List<String>> resultadosPorTime;

    public Partida(Time time1, Time time2) {
        this.time1 = time1;
        this.time2 = time2;

        historico.add(this);
    }

    void registrarResultado(List<Time> resultados) {
        this.vencedor = resultados.get(0);
        Time perdedor = resultados.get(1);

        vencedor.adicionarPontuacao(3);
        vencedor.adicionarHistorico(perdedor.getNome() + " - Venceu");
        perdedor.adicionarHistorico(vencedor.getNome() + " - Perdeu");
    }

    Time getResultadoPara(Time time) {
        return time1;
    }

    static List<Partida> getHistorico() {
        return historico;
    }

    List<String> getResultadosDoTime(Time time) {
        return time.getHistorico();
    }

    Time getTime1() {
        return time1;
    }
    
    Time getTime2() {
        return time2;
    }
    
    Time getVencedor() {
        return vencedor;
    }

}
