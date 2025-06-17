import java.util.*;

public class positiveNegativeOrZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i+1) + ": ");
            arr[i] = sc.nextInt();

            if (arr[i] > 0) {
                System.out.println("Positive " + (arr[i] % 2 == 0 ? "Even" : "Odd"));
            } else if (arr[i] < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Zero");
            }
        }

        if (arr[0] == arr[4]) {
            System.out.println("First and last elements are equal.");
        } else if (arr[0] > arr[4]) {
            System.out.println("First element is greater than last.");
        } else {
            System.out.println("First element is less than last.");
        }
    }
}
