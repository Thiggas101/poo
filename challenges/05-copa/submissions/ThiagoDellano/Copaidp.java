// Classe Time
import java.util.SortedSet;
import java.util.TreeSet;

public class Time {
    private String nome;
    private int pontuacao;
    private SortedSet<String> atletas;

    public Time(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
        this.atletas = new TreeSet<>();
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void adicionarAtleta(String nomeAtleta) {
        atletas.add(nomeAtleta);
    }

    public SortedSet<String> getAtletas() {
        return atletas;
    }

    public void adicionarPontuacao(int pontos) {
        this.pontuacao += pontos;
    }
}

// Classe Partida
import java.util.*;

public class Partida {
    private Time time1;
    private Time time2;
    private Time vencedor;
    private static List<Partida> historico = new ArrayList<>();
    private static Map<Time, List<String>> resultadosPorTime = new HashMap<>();

    public Partida(Time time1, Time time2, Time vencedor) {
        this.time1 = time1;
        this.time2 = time2;
        this.vencedor = vencedor;
        registrarResultado();
    }

    private void registrarResultado() {
        time1.adicionarPontuacao(time1 == vencedor ? 3 : 0);
        time2.adicionarPontuacao(time2 == vencedor ? 3 : 0);

        resultadosPorTime.computeIfAbsent(time1, k -> new ArrayList<>()).add(
            time2.getNome() + " - " + (time1 == vencedor ? "Venceu" : "Perdeu")
        );
        resultadosPorTime.computeIfAbsent(time2, k -> new ArrayList<>()).add(
            time1.getNome() + " - " + (time2 == vencedor ? "Venceu" : "Perdeu")
        );

        historico.add(this);
    }

    public static List<Partida> getHistorico() {
        return historico;
    }

    public static List<String> getResultadosDoTime(Time time) {
        return resultadosPorTime.getOrDefault(time, new ArrayList<>());
    }

    public Time getTime1() { return time1; }
    public Time getTime2() { return time2; }
    public Time getVencedor() { return vencedor; }
}

// Classe principal CopaIDPApp
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class CopaIDPApp {
    public static void main(String[] args) {
        Time time1 = new Time("Time1");
        time1.adicionarAtleta("Atleta1");
        time1.adicionarAtleta("Atleta2");

        Time time2 = new Time("Time2");
        time2.adicionarAtleta("Atleta3");
        time2.adicionarAtleta("Atleta4");

        Time time3 = new Time("Time3");
        time3.adicionarAtleta("Atleta5");
        time3.adicionarAtleta("Atleta6");

        List<Time> times = List.of(time1, time2, time3);

        new Partida(time1, time2, time1);
        new Partida(time2, time3, time3);
        new Partida(time1, time3, time3);
        new Partida(time3, time1, time3);

        gerarRelatorio(times);
    }

    private static void gerarRelatorio(List<Time> times) {
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório da Copa IDP\n\n");

        for (Time time : times) {
            sb.append(time.getNome()).append(" - ").append(time.getPontuacao()).append(" pontos\n");
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
        for (Partida p : Partida.getHistorico()) {
            sb.append(p.getTime1().getNome())
              .append(" vs ")
              .append(p.getTime2().getNome())
              .append(" - Vencedor: ")
              .append(p.getVencedor().getNome())
              .append("\n");
        }

        Path path = Paths.get("relatorio_copa_idp.txt");
        try {
            Files.writeString(path, sb.toString());
        } catch (IOException e) {
            System.err.println("Erro ao escrever o relatório: " + e.getMessage());
        }
    }
}
