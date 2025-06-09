import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Time {
    private String nome;
    private int pontuacao;
    private SortedSet<String> atletas;
    private List<String> historicoPartidas;

    public Time(String nome) {
        this.nome = nome;
        this.atletas = new TreeSet<String>();
        this.pontuacao = 0;

        historicoPartidas = new ArrayList<>();
    }

    String getNome() {
        return this.nome;
    }

    int getPontuacao() {
        return this.pontuacao;
    }

    void adicionarAtletas(String... nomeAtletas) {
        this.atletas.addAll(Arrays.asList(nomeAtletas));
    }

    Set<String> getAtletas() {
        return this.atletas;
    }

    void adicionarPontuacao(int pontos) {
        this.pontuacao += pontos;
    }

    void adicionarHistorico(String historico) {
        this.historicoPartidas.add(historico);
    }

    List<String> getHistorico() {
        return historicoPartidas;
    }
}