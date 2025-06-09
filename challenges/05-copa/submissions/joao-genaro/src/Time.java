public class Time {
    private String nome;
    private int totalGols;

    public Time(String nome) {
        this.nome = nome;
        this.totalGols = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getTotalGols() {
        return totalGols;
    }

    public void adicionarGols(int gols) {
        this.totalGols += gols;
    }
}