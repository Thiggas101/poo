public class PhoneApp {
    public static void main(String[] args) {

        try {
            Phone p1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Phone p2 = new Phone("Samsung", "12345");
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Phone p3 = new Phone("iPhone", "1234567890123456");
            System.out.println("Objeto criado com sucesso: " + p3);
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
