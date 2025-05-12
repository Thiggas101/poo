public class PhoneApp {
    public static void main(String[] args) {
        try {
            Phone phone = new Phone(null, "1234567891231234");
            System.out.println("phone criado com sucesso " + phone.getName() + " " + phone.getSerialNumber());
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            Phone phone = new Phone("123123", "1234567891");
            System.out.println("phone criado com sucesso " + phone.getName() + " " + phone.getSerialNumber());
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            Phone phone = new Phone("123123", "1234567891231234");
            System.out.println("phone criado com sucesso " + phone.getName() + " " + phone.getSerialNumber());
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
