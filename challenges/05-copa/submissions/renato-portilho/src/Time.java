import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Time {
    private String nome;
    private int pontuacao;
    private SortedSet<String> atletas = new TreeSet<>();

    public Time(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
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
        pontuacao += pontos;
    }
}
