
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partida {
  private final Time time1;
  private final Time time2;
  private final Time timeVencedor;
  private static final List<Partida> historico = new ArrayList<>();
  private static final Map<Time,List<String>> resultadoPorTime = new HashMap<>();


  public Partida(Time time1, Time time2, Time timeVencedor) {
    this.time1 = time1;
    this.time2 = time2;
    this.timeVencedor = timeVencedor;
    if(resultadoPorTime.get(time1) == null) resultadoPorTime.put(time1, new ArrayList<>());
    if(resultadoPorTime.get(time2) == null) resultadoPorTime.put(time2, new ArrayList<>());
  }

  public static void registrarResultado(Partida partida){
    historico.add(partida);
    if (partida.timeVencedor.getNome().equals(partida.time1.getNome())){
      resultadoPorTime.get(partida.time1).add("Venceu");
      resultadoPorTime.get(partida.time2).add("Perdeu");
      partida.time1.adicionarPontuacao(3);
    }
    else{
      resultadoPorTime.get(partida.time1).add("Perdeu");
      resultadoPorTime.get(partida.time2).add("Venceu");
      partida.time2.adicionarPontuacao(3);
    }
  }

  public List<String> getResultadoPorTime(Time time){
    List<String> listaResultados =  resultadoPorTime.get(time);
    return listaResultados;
  }
  
  public static List<Partida> getHistorico() {
    try{
      List<String> linhas = new ArrayList<>();
      // List<Map.Entry<Time, List<String>>> listaDeEntradas = new ArrayList<>(resultadoPorTime.entrySet());
      // for (Time time : listaDeEntradas) {
        
      // }
      for (Partida partida : historico) {
        linhas.add(partida.toString());
      }
      Files.write(Path.of("relatorio_copa_idp.txt"), linhas, StandardOpenOption.APPEND);
    }catch(IOException exception){
      System.out.println("erro no relatorio");
    }
    return historico;
  }

  public Time getTime1() {
    return time1;
  }

  public Time getTime2() {
    return time2;
  }

  public Time getTimeVencedor() {
    return timeVencedor;
  }

    @Override
    public String toString() {
        return time1.getNome() + " vs " + time2.getNome() + " - Vencedor " + getTimeVencedor();
    }
}
