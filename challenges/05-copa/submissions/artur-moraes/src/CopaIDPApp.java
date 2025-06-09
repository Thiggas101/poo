import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class CopaIDPApp {
    public static void main(String[] args) {
        Time vasco = new Time("Vasco");
        vasco.adicionarAtleta("Lucas");
        vasco.adicionarAtleta("Miguel");

        Time botafogo = new Time("Botafogo");
        botafogo.adicionarAtleta("Carlos");
        botafogo.adicionarAtleta("João");

        Time girlpwr = new Time("girlpwr");
        girlpwr.adicionarAtleta("Dedeia");
        girlpwr.adicionarAtleta("Solange");

        List<Time> times = List.of(vasco, botafogo, girlpwr);

        // Criar e registrar partidas
        new Partida(botafogo, girlpwr, girlpwr).registrarResultado();
        new Partida(vasco, girlpwr, vasco).registrarResultado();
        new Partida(botafogo, vasco, botafogo).registrarResultado();
        new Partida(vasco, girlpwr, girlpwr).registrarResultado();

        // Criar relatório
        StringBuilder report = new StringBuilder();
        report.append("Relatório da Copa IDP\n\n");

        for (Time t : times) {
            report.append(t.getNome()).append(" - ").append(t.getPontuacao()).append(" pontos\n");
            Iterator<String> atletaitr = t.getAtletas().iterator();
            report.append("- Atletas: \n");
            while(atletaitr.hasNext()){
                report.append(atletaitr.next()).append("\n");
            }

            report.append("- Partidas:\n");
            for (String resultado : Partida.getResultadosDoTime(t)) {
                report.append("  - ").append(resultado).append("\n");
            }
            report.append("\n");
        }

        report.append("Todas as Partidas:\n");
        for (Partida p : Partida.getHistorico()) {
            report.append(p.getTime1().getNome())
                  .append(" vs ")
                  .append(p.getTime2().getNome())
                  .append(" - Vencedor: ")
                  .append(p.getVencedor().getNome())
                  .append("\n");
        }

        // Escrever em arquivo
        Path path = Paths.get("relatorio_copa_idp.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(report.toString());
            System.out.println("Relatório gerado com sucesso: " + path.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erro ao gerar o relatório: " + e.getMessage());
        }
    }
}
