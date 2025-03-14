import java.util.Scanner;

public class ParkingGarage {

    // Método para calcular a taxa de estacionamento
    public static double calculateCharges(double hours) {
        double fee;
        if (hours <= 3) {
            fee = 2.00;
        } else {
            fee = 2.00 + (Math.ceil(hours - 3) * 0.50);
        }
        return Math.min(fee, 10.00); // Garante que não ultrapasse o valor máximo de R$10,00
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalRevenue = 0.0;
        int customerCount = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hours = scanner.nextDouble();
            
            if (hours == -1) {
                break; // Sai do loop se o usuário digitar -1
            }

            double charge = calculateCharges(hours);
            totalRevenue += charge;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", customerCount++, charge);
        }
        
        System.out.printf("Total arrecadado ontem: $%.2f%n", totalRevenue);
        scanner.close();
    }
}

