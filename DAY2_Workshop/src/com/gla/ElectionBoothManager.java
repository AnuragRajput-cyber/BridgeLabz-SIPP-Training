package com.gla;
import java.util.Scanner;

public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean votingOpen = true;

        while (votingOpen) {
            System.out.print("\nEnter voter's age (or -1 to exit): ");
            int age = scanner.nextInt();

            if (age == -1) {
                System.out.println("Voting closed.");
                break;
            }

            if (age >= 18) {
                System.out.println("Eligible to vote.");
                System.out.print("Cast your vote (1/2/3): ");
                int vote = scanner.nextInt();
                if (vote == 1 || vote == 2 || vote == 3) {
                    System.out.println("Vote recorded for candidate " + vote + ".");
                } else {
                    System.out.println("Invalid candidate number.");
                }
            } else {
                System.out.println("Not eligible to vote.");
            }
        }

        scanner.close();
    }
}
