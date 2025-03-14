import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        if (hours <= 3.0) {
            return 2.00;
        }
        double charge = 2.00 + (Math.ceil(hours - 3.0) * 0.50);
        return Math.min(charge, 10.00);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int customerCount = 0;
        double totalRevenue = 0.0;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hours = scanner.nextDouble();

            if (hours == -1) {
                break;
            }

            if (hours <= 0 || hours > 24) {
                System.out.println("Erro: O número de horas deve estar entre 0.1 e 24.");
                continue;
            }

            double charge = calculateCharges(hours);
            customerCount++;
            totalRevenue += charge;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", customerCount, charge);
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", totalRevenue);

        scanner.close();
    }
}
