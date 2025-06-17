import java.util.Scanner;
public class sumUsingLoopAndFormula {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Invalid natural number.");
            return;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        int formulaSum = n * (n + 1) / 2;
        System.out.println("Sum using loop: " + sum);
        System.out.println("Sum using formula: " + formulaSum);
        System.out.println("Both computations are " + (sum == formulaSum ? "correct." : "not matching."));
    }
}
