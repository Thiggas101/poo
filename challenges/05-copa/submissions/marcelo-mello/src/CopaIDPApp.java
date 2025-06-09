import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class CopaIDPApp {
    public static void main(String[] args) {
        Time time1 = new Time("Time1");
        time1.adicionarAtleta("Ana");
        time1.adicionarAtleta("Bruno");

        Time time2 = new Time("Time2");
        time2.adicionarAtleta("Carlos");
        time2.adicionarAtleta("Daniela");

        Time time3 = new Time("Time3");
        time3.adicionarAtleta("Eduarda");
        time3.adicionarAtleta("Felipe");

        new Partida(time1, time2, time1);
        new Partida(time2, time3, time3);
        new Partida(time1, time3, time3);
        new Partida(time3, time1, time3);

        List<String> linhas = new ArrayList<>();
        linhas.add("Relatório da Copa IDP\n");

        List<Time> times = List.of(time1, time2, time3);
        for (Time time : times) {
            linhas.add(time.getNome() + " - " + time.getPontuacao() + " pontos");
            linhas.add("- Atletas:");
            for (String atleta : time.getAtletas()) {
                linhas.add("  " + atleta);
            }
            linhas.add("- Partidas:");
            for (String resultado : Partida.getResultadosDoTime(time)) {
                linhas.add(" - " + resultado);
            }
            linhas.add("");
        }

        linhas.add("Todas as Partidas:");
        for (Partida partida : Partida.getHistorico()) {
            linhas.add(partida.getTime1().getNome() + " vs " + partida.getTime2().getNome()
                    + " - Vencedor: " + partida.getVencedor().getNome());
        }

        try {
            Files.write(Paths.get("relatorio_copa_idp.txt"), linhas);
            System.out.println("Relatório gerado com sucesso em relatorio_copa_idp.txt");
        } catch (IOException e) {
            System.err.println("Erro ao gerar relatório: " + e.getMessage());
        }
    }
}