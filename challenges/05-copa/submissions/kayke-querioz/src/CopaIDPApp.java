import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CopaIDPApp {
    public static void main(String[] args) {
        Time time1 = new Time("Time1");
        Time time2 = new Time("Time2");
        Time time3 = new Time("Time3");

        time1.adicionarAtleta("Atleta1");
        time1.adicionarAtleta("Atleta2");

        time2.adicionarAtleta("Atleta3");
        time2.adicionarAtleta("Atleta4");

        time3.adicionarAtleta("Atleta5");
        time3.adicionarAtleta("Atleta6");

        List<Time> times = Arrays.asList(time1, time2, time3);

        new Partida(time1, time2, time1);
        new Partida(time2, time3, time3);
        new Partida(time1, time3, time3);
        new Partida(time1, time2, time1);

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório da Copa IDP\n\n");

        for (Time time : times) {
            relatorio.append(time.getNome())
                     .append(" - ")
                     .append(time.getPontuacao())
                     .append(" pontos\n");

            relatorio.append("- Atletas:\n");
            for (String atleta : time.getAtletas()) {
                relatorio.append("  ").append(atleta).append("\n");
            }

            relatorio.append("- Partidas:\n");
            for (String resultado : Partida.getResultadosDoTime(time)) {
                relatorio.append(" - ").append(resultado).append("\n");
            }

            relatorio.append("\n");
        }

        relatorio.append("Todas as Partidas:\n");
        for (Partida partida : Partida.getHistorico()) {
            relatorio.append(partida.getTime1().getNome())
                     .append(" vs ")
                     .append(partida.getTime2().getNome())
                     .append(" - Vencedor: ")
                     .append(partida.getVencedor().getNome())
                     .append("\n");
        }

        Path path = Paths.get("relatorio_copa_idp.txt");
        try {
            Files.write(path, relatorio.toString().getBytes());
            System.out.println("Relatório gerado com sucesso: " + path.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erro ao gravar o relatório: " + e.getMessage());
        }
    }
}
