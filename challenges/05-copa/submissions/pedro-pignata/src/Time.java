import java.util.ArrayList;
import java.util.List;

public class Time {
    private String nome;
    private List<String> atletas;
    private int pontuacao;

    public Time(String nome) {
        this.nome = nome;
        this.atletas = new ArrayList<>();
        this.pontuacao = 0;
    }

    public void adicionarAtleta(String nomeAtleta) {
        if (nomeAtleta != null && !nomeAtleta.trim().isEmpty()) {
            atletas.add(nomeAtleta);
        }
    }

    public void adicionarVitoria() {
        pontuacao += 3;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getAtletas() {
        return atletas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Time outro) {
            return this.nome.equalsIgnoreCase(outro.nome);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return nome.toLowerCase().hashCode();
    }
}



