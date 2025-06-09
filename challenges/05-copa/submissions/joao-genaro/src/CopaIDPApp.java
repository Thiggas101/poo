import java.nio.file.*;
import java.util.*;

public class CopaIDPApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Time> times = new HashMap<>();
        List<Partida> partidas = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(Path.of("jogos.txt"));

            for (String linha : linhas) {
                String[] partes = linha.split(";");
                if (partes.length < 4) continue;

                String nome1 = partes[0].trim();
                String nome2 = partes[1].trim();
                int gols1 = Integer.parseInt(partes[2].trim());
                int gols2 = Integer.parseInt(partes[3].trim());

                Time time1 = times.computeIfAbsent(nome1, Time::new);
                Time time2 = times.computeIfAbsent(nome2, Time::new);

                Partida partida = new Partida(time1, time2, gols1, gols2);
                partidas.add(partida);
            }

        } catch (Exception e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
            return;
        }

        System.out.println("Lista de partidas:");
        for (Partida p : partidas) {
            System.out.println(p);
        }

        System.out.print("\nDigite o nome do time para consultar os gols: ");
        String consulta = scanner.nextLine().trim();

        Time consultado = times.get(consulta);
        if (consultado != null) {
            System.out.println("Total de gols do " + consulta + ": " + consultado.getTotalGols());
        } else {
            System.out.println("Time não encontrado.");
        }
    }
}