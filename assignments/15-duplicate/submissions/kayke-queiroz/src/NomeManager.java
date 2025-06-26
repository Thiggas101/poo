import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class NomeManager {
    private Set<String> nomesNormalizados;
    private HashMap<String, String> nomesOriginais;

    public NomeManager() {
        nomesNormalizados = new TreeSet<>();
        nomesOriginais = new HashMap<>();
    }

    public void adicionarNome(String nome) {
        String nomeNormalizado = nome.toLowerCase();
        if (!nomesNormalizados.contains(nomeNormalizado)) {
            nomesNormalizados.add(nomeNormalizado);
            nomesOriginais.put(nomeNormalizado, Util.capitalize(nome));
        }
    }

    public boolean nomeExiste(String nome) {
        return nomesNormalizados.contains(nome.toLowerCase());
    }

    public void exibirNomes() {
        for (String nome : nomesNormalizados) {
            System.out.println(nomesOriginais.get(nome));
        }
    }
}
