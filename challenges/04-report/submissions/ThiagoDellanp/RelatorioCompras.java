import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso correto: java RelatorioCompras <arquivoEntrada> <arquivoSaida>");
            return;
        }

        Path caminhoEntrada = Path.of(args[0]);
        Path caminhoSaida = Path.of(args[1]);

        ArrayList<String> nomesClientes = new ArrayList<>();
        ArrayList<Double> totaisCompras = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(caminhoEntrada);

            for (String linha : linhas) {
                String[] partes = linha.split(",");

                if (partes.length < 3) {
                    System.out.println("Linha ignorada (malformada): " + linha);
                    continue;
                }

                String nomeCliente = partes[0].trim();
                String valorStr = partes[2].trim();

                double valor;
                try {
                    valor = Double.parseDouble(valorStr);
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido na linha: " + linha);
                    continue;
                }

                int index = nomesClientes.indexOf(nomeCliente);
                if (index != -1) {
                    double novoTotal = totaisCompras.get(index) + valor;
                    totaisCompras.set(index, novoTotal);
                } else {
                    nomesClientes.add(nomeCliente);
                    totaisCompras.add(valor);
                }
            }

            List<String> linhasSaida = new ArrayList<>();
            for (int i = 0; i < nomesClientes.size(); i++) {
                String linha = nomesClientes.get(i) + ": " + totaisCompras.get(i);
                linhasSaida.add(linha);
            }

            Files.write(caminhoSaida, linhasSaida);
            System.out.println("Relatório gerado com sucesso em: " + caminhoSaida);

        } catch (IOException e) {
            System.out.println("Erro ao ler ou escrever arquivos: " + e.getMessage());
        }
    }
}
