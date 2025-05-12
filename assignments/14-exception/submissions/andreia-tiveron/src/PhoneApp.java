public class PhoneApp{
    public static void main(String[] args){
        try {
            Phone ph1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Phone ph2 = new Phone("Nokia", "12345");
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        try {
            Phone ph3 = new Phone("iphone", "1234567890987654");
            System.out.println("Telefone criado com sucesso: " + ph3.getName());
        } catch (ValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}