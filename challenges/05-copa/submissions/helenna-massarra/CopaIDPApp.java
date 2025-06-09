import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CopaIDPApp {
    public static void main(String[] args) {
        // Criando os times
        Time time1 = new Time("Time1");
        time1.adicionarAtleta("Atleta1");
        time1.adicionarAtleta("Atleta2");

        Time time2 = new Time("Time2");
        time2.adicionarAtleta("Atleta3");
        time2.adicionarAtleta("Atleta4");

        Time time3 = new Time("Time3");
        time3.adicionarAtleta("Atleta5");
        time3.adicionarAtleta("Atleta6");

        List<Time> times = Arrays.asList(time1, time2, time3);

        // Criando partidas
        new Partida(time1, time2, time1);
        new Partida(time2, time3, time3);
        new Partida(time1, time3, time3);
        new Partida(time3, time1, time3);

        // Gerar relatório
        gerarRelatorio(times);
    }

    private static void gerarRelatorio(List<Time> times) {
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório da Copa IDP\n\n");

        for (Time time : times) {
            sb.append(time.toString()).append("\n");
            sb.append("- Atletas:\n");
            for (String atleta : time.getAtletas()) {
                sb.append("  ").append(atleta).append("\n");
            }
            sb.append("- Partidas:\n");
            for (String resultado : Partida.getResultadosDoTime(time)) {
                sb.append(" - ").append(resultado).append("\n");
            }
            sb.append("\n");
        }

        sb.append("Todas as Partidas:\n");
        for (Partida partida : Partida.getHistorico()) {
            sb.append(partida.getTime1().getNome()).append(" vs ").append(partida.getTime2().getNome())
              .append(" - Vencedor: ").append(partida.getVencedor().getNome()).append("\n");
        }

        Path path = Paths.get("relatorio_copa_idp.txt");
        try {
            Files.write(path, sb.toString().getBytes());
            System.out.println("Relatório gerado com sucesso em " + path.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erro ao gravar o relatório: " + e.getMessage());
        }
    }
}
