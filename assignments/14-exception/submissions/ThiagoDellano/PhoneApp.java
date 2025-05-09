public class PhoneApp {
    public static void main(String[] args) {
        // Teste 1: nome vazio
        try {
            Phone p1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 2: número de série com menos de 16 dígitos
        try {
            Phone p2 = new Phone("Samsung", "12345678");
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 3: dados válidos
        try {
            Phone p3 = new Phone("iPhone", "ABCDEF1234567890");
            System.out.println("Telefone criado com sucesso: " + p3);
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
