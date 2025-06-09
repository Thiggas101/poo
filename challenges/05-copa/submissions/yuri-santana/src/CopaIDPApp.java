
public class CopaIDPApp {
  public static void main(String[] args) {
    Time time1 = new Time("Real Madrid", 0);
    time1.adicionarAtleta("Yuri");
    time1.adicionarAtleta("Fabricio");

    Time time2 = new Time("Barca", 0);
    time2.adicionarAtleta("Pig");
    time2.adicionarAtleta("dutra");

    Time time3 = new Time("Flamengo", 0);
    time3.adicionarAtleta("Renato");
    time3.adicionarAtleta("Rafa");

    Partida partida1 = new Partida(time1, time2, time1);
    Partida partida2 = new Partida(time1, time3, time1);
    Partida partida3 = new Partida(time3, time2, time3);
    Partida partida4 = new Partida(time1, time2, time2);

    Partida.registrarResultado(partida1);
    Partida.registrarResultado(partida2);
    Partida.registrarResultado(partida3);
    Partida.registrarResultado(partida4);

    Partida.getHistorico();
  }
}
