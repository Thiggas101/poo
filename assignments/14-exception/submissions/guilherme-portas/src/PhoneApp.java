public class PhoneApp {
    public static void main(String[] args) {
        Phone phoneNameErr = createPhone("", "1234567891234567");
        Phone phoneSerialErr = createPhone("Apple", "123456789");
        Phone phoneOk = createPhone("Samsung", "1234567891234567");
    }
    
    public static Phone createPhone(String name, String serialNumber) {
        try {
            Phone phone = new Phone(name, serialNumber);
            System.out.println("Telefone criado com sucesso!");
            return phone;
        }
        catch(ValidationException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
