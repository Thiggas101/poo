import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

class CopaIDPApp {
    public static void main(String[] args) {
        Time time1 = new Time("Time1"), time2 = new Time("Time2"), time3 = new Time("Time3"), time4 = new Time("Time4");
        time1.adicionarAtletas("Atleta1", "Atleta2");
        time2.adicionarAtletas("Atleta3", "Atleta4");
        time3.adicionarAtletas("Atleta5", "Atleta6");
        time4.adicionarAtletas("Atleta7", "Atleta8");

        Partida partida1 = new Partida(time1, time2);
        partida1.registrarResultado(simularPartida(partida1));
        Partida partida2 = new Partida(time1, time3);
        partida2.registrarResultado(simularPartida(partida2));
        Partida partida3 = new Partida(time1, time4);
        partida3.registrarResultado(simularPartida(partida3));
        Partida partida4 = new Partida(time2, time3);
        partida4.registrarResultado(simularPartida(partida4));
        Partida partida5 = new Partida(time2, time4);
        partida5.registrarResultado(simularPartida(partida5));
        Partida partida6 = new Partida(time3, time4);
        partida6.registrarResultado(simularPartida(partida6));

        gerarRelatorio(List.of(time1, time2, time3, time4), Partida.getHistorico());
    }

    public static List<Time> simularPartida(Partida partida) {
        Random rand = new Random();
        if(rand.nextBoolean()) {
            return Arrays.asList(partida.getTime1(), partida.getTime2());
        }
        else {
            return Arrays.asList(partida.getTime2(), partida.getTime1());
        }
    }

        private static void gerarRelatorio(List<Time> times, List<Partida> todasPartidas) {
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório da Copa IDP\n\n");

        // Informações de cada time
        for (Time time : times) {
            sb.append(time.getNome()).append(" - ").append(time.getPontuacao()).append(" pontos\n");
            sb.append("- Atletas:\n");
            for (String atleta : time.getAtletas()) {
                sb.append("  ").append(atleta).append("\n");
            }
            sb.append("- Partidas:\n");
            if (time.getHistorico().isEmpty()) {
                sb.append("  Nenhuma partida registrada.\n");
            } else {
                for (String historico : time.getHistorico()) {
                    sb.append(" - ").append(historico).append("\n");
                }
            }
            sb.append("\n");
        }

        // Todas as Partidas
        sb.append("Todas as Partidas:\n");
        for (Partida partida : todasPartidas) {
            sb.append(partida.getTime1().getNome())
              .append(" vs ")
              .append(partida.getTime2().getNome())
              .append(" - Vencedor: ")
              .append(partida.getVencedor().getNome())
              .append("\n");
        }

        // Gravar no arquivo
        Path caminhoArquivo = Paths.get("relatorio_copa_idp.txt");
        try (var writer = Files.newBufferedWriter(caminhoArquivo)) {
            writer.write(sb.toString());
            System.out.println("Relatório gerado com sucesso em: " + caminhoArquivo.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erro ao gravar o relatório: " + e.getMessage());
        }
    }
}