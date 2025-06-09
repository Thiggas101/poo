import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Set;

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

    public Set<String> getAtletas() {
        return atletas;
    }

    public void adicionarPontuacao(int pontos) {
        this.pontuacao += pontos;
    }
} 