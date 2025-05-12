public class PhoneApp {
    public static void main(String[] args) {
        try {
            Phone phone = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Phone phone = new Phone("Iphone", "123456");
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());

        }

        try {
            Phone phone = new Phone("Iphone", "1234567890123456");
            System.out.println("Telefone criado com sucesso!");
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}