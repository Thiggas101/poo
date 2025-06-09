import java.util.SortedSet;
import java.util.TreeSet;

public class Time {
    private String nome;
    private int pontuacao;
    private SortedSet<String> atletas;

    public Time(String nome){
        this.nome = nome;
        this.pontuacao = 0;
        this.atletas = new TreeSet<>();
    }
    
    public String getNome(){
        return nome;
    }

    public int getPontuacao(){
        return pontuacao;
    }

    public SortedSet<String> getAtletas() {
        return atletas;
    }

    void adicionarAtleta(String nomeAtleta){
        this.atletas.add(nomeAtleta);
    }

    public void adicionarPontuacao(int pontos) {
        this.pontuacao += pontos;
    }
}

