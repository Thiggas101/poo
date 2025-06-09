import java.util.ArrayList;
import java.util.List;

public class CopaIDPApp {
    public static void main(String[] args) {
        // Criando times
        Time time1 = new Time("Flamengo");
        time1.adicionarAtleta("Pignata");
        time1.adicionarAtleta("Arrascaeta");
        time1.adicionarAtleta("Bruno");

        Time time2 = new Time("Manchester United");
        time2.adicionarAtleta("Casemiro");
        time2.adicionarAtleta("Diallo");
        time2.adicionarAtleta("Garnacho");

        Time time3 = new Time("Roma");
        time3.adicionarAtleta("Pelegrini");
        time3.adicionarAtleta("Dybala");
        time3.adicionarAtleta("Paredes");

        List<Partida> partidas = new ArrayList<>();
        partidas.add(new Partida(time1, time2, time3, time1)); 
        partidas.add(new Partida(time1, time2, time3, time2)); 
        partidas.add(new Partida(time1, time2, time3, time3)); 

        List<Time> times = List.of(time1, time2, time3);

        StringBuilder relatorio = new StringBuilder("\n===== RELATÓRIO DA COPA IDP =====\n");
        for (Time time : times) {
            relatorio.append("Time: ").append(time.getNome()).append(" - Pontuação: ").append(time.getPontuacao()).append("\n");
            relatorio.append("Atletas:\n");
            for (String atleta : time.getAtletas()) {
                relatorio.append(" - ").append(atleta).append("\n");
            }
            relatorio.append("Histórico de Partidas:\n");
            for (Partida partida : partidas) {
                String resultado = partida.getResultadoPara(time);
                if (resultado != null) {
                    List<String> adversarios = partida.getAdversariosDe(time);
                    relatorio.append(" - Contra ").append(adversarios.get(0)).append(" e ").append(adversarios.get(1)).append(" - ").append(resultado).append("\n");
                }
            }
            relatorio.append("\n");
        }
        System.out.println(relatorio.toString());
    }
}
