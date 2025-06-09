import java.util.*;

public class Time {
    private String nome;
    private int pontuacao = 0;
    private SortedSet<String> atletas = new TreeSet<>();

    public Time(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return nome + " - " + pontuacao + " pontos";
    }
}