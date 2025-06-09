import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CopaIDPApp{
    public static void main(String[] args) {
        Time timeA = new Time ("TimePipipi");
        Time timeB = new Time ("TimePopopo");
        Time timeC = new Time ("TimePupupu");
        List<Time> times = Arrays.asList(timeA, timeB, timeC);


        timeA.adicionarAtleta("Anna Julia");
        timeA.adicionarAtleta("Roberto Carlos");

        timeB.adicionarAtleta("Joana");
        timeB.adicionarAtleta("Tales");

        timeC.adicionarAtleta("Mariazinha");
        timeC.adicionarAtleta("HomemCalvo");

        Partida p1 = new Partida(timeA, timeB, timeA);
        p1.registrarResultado();
        

        Partida p2 = new Partida(timeA, timeC, timeA);
        p2.registrarResultado();
        

        Partida p3 = new Partida(timeB, timeC, timeC);
        p3.registrarResultado();
      

        Partida p4 = new Partida(timeA, timeB, timeB);
        p4.registrarResultado();
        

        StringBuilder report = new StringBuilder("Relatório da Copa IDP\n\n");
        
        for (Time time : times) {
            report.append(time.getNome()).append(" - ")
                  .append(time.getPontuacao()).append(" pontos\n");
            report.append("- Atletas:\n");
            for (String atleta : time.getAtletas()) {
                report.append("  ").append(atleta).append("\n");
            }
            report.append("- Partidas:\n");
            for (String resultado : Partida.getResultadosDoTime(time)) {
                report.append(" - ").append(resultado).append("\n");
            }
            report.append("\n");
        }

        report.append("Todas as Partidas:\n");
        for (Partida partida : Partida.getHistorico()) {
            report.append(partida.getTime1().getNome())
                  .append(" vs ")
                  .append(partida.getTime2().getNome())
                  .append(" - Vencedor: ")
                  .append(partida.getVencedor().getNome())
                  .append("\n");
        }

        
        Path caminho = Paths.get("relatorio_copa_idp.txt");
        try {
            Files.write(caminho, report.toString().getBytes(StandardCharsets.UTF_8));
            System.out.println("Relatório gerado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao gravar o relatório: " + e.getMessage());
        }
    }
}