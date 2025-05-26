import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CopaIDPApp {
    public static void main(String[] args) {
        Time time1 = new Time("Tubarões");
        time1.adicionarAtleta("Ana Paula");
        time1.adicionarAtleta("Carlos Souza");

        Time time2 = new Time("Leões");
        time2.adicionarAtleta("Bruno Lima");
        time2.adicionarAtleta("Joana Alves");

        Time time3 = new Time("Águias");
        time3.adicionarAtleta("Fernanda Silva");
        time3.adicionarAtleta("Lucas Rocha");

        List<Time> todosTimes = Arrays.asList(time1, time2, time3);

        new Partida(time1, time2, time1);
        new Partida(time2, time3, time3);
        new Partida(time1, time3, time3);

        gerarRelatorio(todosTimes);
    }

    private static void gerarRelatorio(List<Time> todosTimes) {
        List<String> linhas = new ArrayList<>();
        linhas.add("Relatório da Copa IDP\n");

        Iterator timesItr = todosTimes.iterator();
        
        while (timesItr.hasNext()){
            Time t = (Time) timesItr.next();

            linhas.add(t.getNome() + " - " + t.getPontuacao() + " pontos");
            linhas.add("- Atletas:");

            Set<String> atletas = t.getAtletas();
            Iterator atletasItr = atletas.iterator();
            while (atletasItr.hasNext()){
                linhas.add("  " + atletasItr.next());
            }
            linhas.add("- Partidas:");
            List<String> resultados = Partida.getResultadosDoTime(t);
            linhas.addAll(resultados);
            linhas.add("");
        }

        linhas.add("Todas as Partidas:");
        for (Partida p : Partida.getHistorico()) {
            linhas.add(p.getTime1().getNome() + " vs " + p.getTime2().getNome() + " - Vencedor: " + p.getVencedor().getNome());
        }

        Path caminho = Paths.get("relatorio_copa_idp.txt");
        try {
            Files.write(caminho, linhas);
        } catch (IOException e) {
            System.out.println("Erro ao gerar o relatório: " + e.getMessage());
        }
    }
}
