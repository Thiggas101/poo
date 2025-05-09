import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.xml.bind.JAXB;

public class CreateSequentialFile {
    public static void main(String[] args) {

        try(BufferedWriter output = Files.newBufferedWriter(Path.of("clients.xml"))) { //Paths.get

          Scanner input = new Scanner(System.in);
      
          List<Account> accountList = new ArrayList<>();

            System.out.printf("%s%n%s%n? ",
            "Enter account number, first name, last name and balance.",
            "Enter end-of-file indicator to end input.");

            while (input.hasNext()) {
                try {
                    Account record = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());
                    accountList.add(record);
                } catch (NoSuchElementException elementException) {
                    System.err.println("Invalid input. Please try again.");
                    input.nextLine(); // descarta linha inválida
                }
                
                System.out.print("? ");
            }
          
        } catch(IOException e){
            e.printStackTrace();
        }  
    } 
}
