import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        double charge = 2.00;
        if (hours > 3.0) {
            charge += Math.min((Math.ceil(hours - 3.0) * 0.50), 8.00);
        }
        return charge;
    }

    public static void processParkingFees() {
        Scanner scanner = new Scanner(System.in);
        int customerCount = 0;
        double totalRevenue = 0.0;

        while (true) {
            System.out.print("Informe o tempo de estacionamento em horas (ou digite -1 para encerrar): ");
            double hours = scanner.nextDouble();

            if (hours == -1) break;
            if (hours <= 0 || hours > 24) {
                System.out.println("Tempo inválido! Insira um valor entre 0.1 e 24 horas.");
                continue;
            }

            double charge = calculateCharges(hours);
            customerCount++;
            totalRevenue += charge;

            System.out.printf("Registro do Cliente %d: Valor cobrado: R$%.2f%n", customerCount, charge);
        }

        System.out.printf("Total arrecadado no dia anterior: R$%.2f%n", totalRevenue);
        scanner.close();
    }

    public static void main(String[] args) {
        processParkingFees();
    }
}