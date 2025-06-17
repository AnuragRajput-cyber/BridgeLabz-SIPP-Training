import java.util.Scanner;
public class sumOfNnaturalNumberUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        int sum = 0, i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        int formulaSum = n * (n + 1) / 2;
        System.out.println("Sum using while loop: " + sum);
        System.out.println("Sum using formula: " + formulaSum);
    }
}
