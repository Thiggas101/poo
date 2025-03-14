import java.util.Scanner;

public class ParkingGarage {
    public static double calculateCharges(double hours) {
        if (hours <= 3) {
            return 2.00;
        } else {
            double charge = 2.00 + (Math.ceil(hours - 3) * 0.50);
            return Math.min(charge, 10.00);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalRevenue = 0;
        int customerCount = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hours = scanner.nextDouble();

            if (hours == -1) {
                break;
            }
            if (hours < 0) {
                System.out.println("Erro: O número de horas deve ser positivo.");
                continue;
            }

            double charge = calculateCharges(hours);
            totalRevenue += charge;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", customerCount, charge);
            customerCount++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", totalRevenue);
        scanner.close();
    }
}
