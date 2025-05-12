//Nome: Allan Samuel Alves do Monte
//Matrícula: 24101279

public class PhoneApp {
    public static void main(String[] args) {
        try {
            Phone phone1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone 1: " + e.getMessage());
        }

        try {
            Phone phone2 = new Phone("Telefone 2", "12345");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone 2: " + e.getMessage());
        }

        try {
            Phone phone3 = new Phone("Telefone 3", "9876543210123456");
            System.out.println("Telefone criado com sucesso: " + phone3);
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone 3: " + e.getMessage());
        }
    }
}
