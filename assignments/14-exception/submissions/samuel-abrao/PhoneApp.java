public class PhoneApp {
    public static void main(String[] args) {
        // Caso 1: Nome vazio
        try {
            Phone phone1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar o telefone 1: " + e.getMessage());
        }

        // Caso 2: Serial com menos de 16 dígitos
        try {
            Phone phone2 = new Phone("Samsung", "12345");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar o telefone 2: " + e.getMessage());
        }

        // Caso 3: Dados válidos
        try {
            Phone phone3 = new Phone("iPhone", "1234567890123456");
            System.out.println("Telefone criado com sucesso:");
            System.out.println("Nome: " + phone3.getName());
            System.out.println("Serial: " + phone3.getSerialNumber());
        } catch (ValidationException e) {
            System.out.println("Erro inesperado ao criar telefone válido: " + e.getMessage());
        }
    }
}