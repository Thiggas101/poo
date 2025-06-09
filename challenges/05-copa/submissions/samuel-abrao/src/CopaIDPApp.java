import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CopaIDPApp {
    public static void main(String[] args) throws Exception {
        Time t1 = new Time("Time1");
        t1.adicionarAtleta("Atleta1");
        t1.adicionarAtleta("Atleta2");

        Time t2 = new Time("Time2");
        t2.adicionarAtleta("Atleta3");
        t2.adicionarAtleta("Atleta4");

        Time t3 = new Time("Time3");
        t3.adicionarAtleta("Atleta5");
        t3.adicionarAtleta("Atleta6");

        Partida p1 = new Partida(t1, t2, t1);
        Partida p2 = new Partida(t2, t3, t3);
        Partida p3 = new Partida(t1, t3, t3);
        Partida p4 = new Partida(t2, t1, t1);

        p1.registrarResultado();
        p2.registrarResultado();
        p3.registrarResultado();
        p4.registrarResultado();

        Path path = Paths.get("relatorio_copa_idp.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("Relatório da Copa IDP");
            writer.newLine();
            writer.newLine();

            for (Time time : List.of(t1, t2, t3)) {
                writer.write(time.getNome() + " - " + time.getPontuacao() + " pontos");
                writer.newLine();
                writer.write("- Atletas:");
                writer.newLine();
                for (String atleta : time.getAtletas()) {
                    writer.write("  " + atleta);
                    writer.newLine();
                }
                writer.write("- Partidas:");
                writer.newLine();
                for (String resultado : new Partida(time, null, null).getResultadoPara(time)) {
                    writer.write("  - " + resultado);
                    writer.newLine();
                }
                writer.newLine();
            }

            writer.write("Todas as Partidas:");
            writer.newLine();
            for (Partida p : Partida.getHistorico()) {
                writer.write(p.getTime1().getNome() + " vs " + p.getTime2().getNome()
                    + " - Vencedor: " + p.getVencedor().getNome());
                writer.newLine();
            }
        }
    }
}
