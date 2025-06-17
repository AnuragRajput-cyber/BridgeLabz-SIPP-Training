import java.util.Scanner;
public class sumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0, input;
        while (true) {
            System.out.print("Enter a number (0 to stop): ");
            input = sc.nextDouble();
            if (input == 0.0) break;
            total += input;
        }
        System.out.println("Total sum: " + total);
    }
}
