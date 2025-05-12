public class PhoneApp {
    public static void main(String[] args) {
        try {
            Phone p1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone: " + e.getMessage());
        }

        try {
            Phone p2 = new Phone("iPhone", "12345");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone: " + e.getMessage());
        }

        try {
            Phone p3 = new Phone("Galaxy", "ABCDEF1234567890");
            System.out.println(p3.toString());
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone: " + e.getMessage());
        }
    }
}