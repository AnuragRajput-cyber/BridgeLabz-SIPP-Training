package com.gla;
import java.util.Scanner;

public class CoffeeCounterChronicles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        double gstRate = 0.05; // 5% GST

        while (running) {
            System.out.print("\nEnter coffee type (Espresso/Latte/Cappuccino) or 'exit' to stop: ");
            String type = scanner.nextLine().toLowerCase();

            if (type.equals("exit")) {
                System.out.println("Exiting Coffee Counter...");
                break;
            }

            int pricePerUnit;
            switch (type) {
                case "espresso":
                    pricePerUnit = 100;
                    break;
                case "latte":
                    pricePerUnit = 150;
                    break;
                case "cappuccino":
                    pricePerUnit = 120;
                    break;
                default:
                    System.out.println("Invalid coffee type.");
                    continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // consume newline

            int total = pricePerUnit * quantity;
            double gst = total * gstRate;
            double grandTotal = total + gst;

            System.out.println("Bill Details:");
            System.out.println("Subtotal: ₹" + total);
            System.out.println("GST (5%): ₹" + gst);
            System.out.println("Grand Total: ₹" + grandTotal);
        }

        scanner.close();
    }
}
