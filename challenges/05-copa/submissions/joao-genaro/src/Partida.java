public class Partida {
    private Time time1;
    private Time time2;
    private int gols1;
    private int gols2;

    public Partida(Time time1, Time time2, int gols1, int gols2) {
        this.time1 = time1;
        this.time2 = time2;
        this.gols1 = gols1;
        this.gols2 = gols2;

        time1.adicionarGols(gols1);
        time2.adicionarGols(gols2);
    }

    @Override
    public String toString() {
        return time1.getNome() + " " + gols1 + " x " + gols2 + " " + time2.getNome();
    }
}