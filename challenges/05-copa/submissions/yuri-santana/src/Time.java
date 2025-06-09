import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class Time {
  private String nome;
  private int pontuacao;
  private final SortedSet<String> atletas = new TreeSet<>();
  
  public Time(String nome, int pontuacao) {
    this.nome = nome;
    this.pontuacao = pontuacao;
  }

  public void adicionarAtleta(String nomeAtleta){
    this.atletas.add(nomeAtleta);
  }

  public void adicionarPontuacao(int pontos){
    this.pontuacao += pontos;
  }

  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public int getPontuacao() {
    return pontuacao;
  }
  public void setPontuacao(int pontuacao) {
    this.pontuacao = pontuacao;
  }
  public Set<String> getAtletas() {
    return atletas;
  }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(nome + " - " + pontuacao + "\n-Atletas:\n");
        for (String atleta : atletas) {
          print.append("atleta:" + atleta + "\n");
        }
        return print.toString();
    }
}
