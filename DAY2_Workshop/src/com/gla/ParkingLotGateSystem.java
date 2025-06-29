package com.gla;
import java.util.Scanner;

public class ParkingLotGateSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int capacity = 5;
        int occupancy = 0;
        boolean systemRunning = true;

        while (systemRunning) {
            System.out.println("\n--- Parking Menu ---");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Occupancy");
            System.out.println("4. Exit System");
            System.out.print("Select an option (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (occupancy < capacity) {
                        occupancy++;
                        System.out.println("Vehicle parked. Current occupancy: " + occupancy + "/" + capacity);
                    } else {
                        System.out.println("Parking full!");
                    }
                    break;
                case 2:
                    if (occupancy > 0) {
                        occupancy--;
                        System.out.println("Vehicle exited. Current occupancy: " + occupancy + "/" + capacity);
                    } else {
                        System.out.println("Parking already empty.");
                    }
                    break;
                case 3:
                    System.out.println("Current occupancy: " + occupancy + "/" + capacity);
                    break;
                case 4:
                    System.out.println("Exiting Parking System...");
                    systemRunning = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }

            if (occupancy >= capacity) {
                System.out.println("Parking Lot Full. Exiting system.");
                break;
            }
        }

        scanner.close();
    }
}
