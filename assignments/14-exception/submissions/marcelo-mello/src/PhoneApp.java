public class PhoneApp {
    public static void main(String[] args) {
 
        try {
            Phone p1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone (1): " + e.getMessage());
        }

        try {
            Phone p2 = new Phone("Galaxy S", "12345678");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone (2): " + e.getMessage());
        }

        try {
            Phone p3 = new Phone("iPhone", "ABCDEFGHIJKLMNOP");
            System.out.println("Telefone criado com sucesso: " + p3);
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone (3): " + e.getMessage());
        }
    }
}
