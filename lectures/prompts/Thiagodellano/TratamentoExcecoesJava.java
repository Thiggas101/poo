// Tratamento de Exceções em Java - Código organizado sem classes públicas duplicadas

//  1. Introdução ao Tratamento de Exceções
class ExemploSemTratamento {
    public static void executar() {
        int resultado = 10 / 0;
        System.out.println("Resultado: " + resultado);
    }
}

//  2. Uso do bloco try
import java.io.FileReader;
import java.io.FileNotFoundException;
class ExemploTry {
    public static void executar() {
        try {
            FileReader fr = new FileReader("arquivo.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}

//  3. Uso da palavra-chave throw
class Validador {
    public static void verificarIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade negativa!");
        }
    }

    public static void executar() {
        verificarIdade(-5);
    }
}

//  4. Uso do bloco catch
class ExemploCatch {
    public static void executar() {
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

//  5. Quando usar tratamento de exceções
class PrevenirVsTratar {
    public static void executar() {
        int idade = -1;
        if (idade >= 0) {
            System.out.println("Idade válida.");
        } else {
            System.out.println("Evite idade negativa.");
        }

        try {
            FileReader fr = new FileReader("dados.txt");
        } catch (Exception e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}

//  6. Hierarquia de Classes de Exceção
import java.io.IOException;
class HierarquiaExcecoes {
    public static void executar() throws IOException {
        try {
            throw new IOException("Checked Exception");
        } catch (IOException e) {
            System.out.println("Exceção verificada capturada: " + e.getMessage());
        }

        throw new NullPointerException("Unchecked Exception");
        // throw new OutOfMemoryError("Erro fatal");
    }
}

//  7. Uso do bloco finally
import java.io.*;
class ExemploFinally {
    public static void executar() {
        FileReader fr = null;
        try {
            fr = new FileReader("arquivo.txt");
        } catch (IOException e) {
            System.out.println("Erro na leitura");
        } finally {
            try {
                if (fr != null) fr.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar arquivo");
            }
        }
    }
}

//  8. Encadeamento de Exceções
class EncadeamentoExcecoes {
    public static void executar() {
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            IllegalArgumentException nova = new IllegalArgumentException("Entrada inválida");
            nova.initCause(e);
            throw nova;
        }
    }
}

//  9. Criação de Exceções Definidas pelo Usuário
class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String msg) {
        super(msg);
    }
}

class Conta {
    private double saldo = 100;

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente!");
        }
        saldo -= valor;
    }

    public static void executar() {
        Conta c = new Conta();
        try {
            c.sacar(200);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

//  10. Uso de assert
class ExemploAssert {
    public static void executar() {
        String nome = null;
        assert nome != null : "Nome não pode ser nulo";
        System.out.println("Nome: " + nome);
    }
}

//  11. try-with-resources
class TryWithResources {
    public static void executar() {
        try (BufferedReader br = new BufferedReader(new FileReader("dados.txt"))) {
            String linha = br.readLine();
            System.out.println(linha);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//  Classe principal para testar
public class TratamentoExcecoesJava {
    public static void main(String[] args) {
        // Descomente para testar cada exemplo:
        // ExemploSemTratamento.executar();
        // ExemploTry.executar();
        // Validador.executar();
        // ExemploCatch.executar();
        // PrevenirVsTratar.executar();
        // try { HierarquiaExcecoes.executar(); } catch (Exception e) { e.printStackTrace(); }
        // ExemploFinally.executar();
        // EncadeamentoExcecoes.executar();
        // Conta.executar();
        // ExemploAssert.executar();
        // TryWithResources.executar();
    }
}