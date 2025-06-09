import java.util.ArrayList;
import java.util.List;

public class Partida {
    private Time time1;
    private Time time2;
    private Time time3;
    private Time vencedor;

    public Partida(Time time1, Time time2, Time time3, Time vencedor) {
        if (time1 == null || time2 == null || time3 == null || vencedor == null)
            throw new IllegalArgumentException("Nenhum time pode ser nulo.");
        if (time1.equals(time2) || time1.equals(time3) || time2.equals(time3))
            throw new IllegalArgumentException("Os times devem ser distintos.");
        if (!vencedor.equals(time1) && !vencedor.equals(time2) && !vencedor.equals(time3))
            throw new IllegalArgumentException("O vencedor deve estar entre os três times.");

        this.time1 = time1;
        this.time2 = time2;
        this.time3 = time3;
        this.vencedor = vencedor;
        vencedor.adicionarVitoria();
    }

    public String getResultadoPara(Time time) {
        if (time.equals(vencedor)) return "Venceu";
        if (time.equals(time1) || time.equals(time2) || time.equals(time3)) return "Perdeu";
        return null;
    }

    public List<String> getAdversariosDe(Time time) {
        List<String> adversarios = new ArrayList<>();
        if (time.equals(time1)) {
            adversarios.add(time2.getNome());
            adversarios.add(time3.getNome());
        } else if (time.equals(time2)) {
            adversarios.add(time1.getNome());
            adversarios.add(time3.getNome());
        } else if (time.equals(time3)) {
            adversarios.add(time1.getNome());
            adversarios.add(time2.getNome());
        }
        return adversarios;
    }
}
