import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class FileReaderUtil {
    public static List<Film> readFilmsFromFile(String path) {
        List<Film> films = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    Film film = new Film();
                    film.setTitle(parts[0]);
                    film.setLanguageId(Integer.parseInt(parts[1]));
                    film.setRentalDuration(Integer.parseInt(parts[2]));
                    film.setRentalRate(Double.parseDouble(parts[3]));
                    film.setReplacementCost(Double.parseDouble(parts[4]));
                    films.add(film);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return films;
    }
}