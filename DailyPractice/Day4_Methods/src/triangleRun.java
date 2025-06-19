import java.util.Scanner;

public class triangleRun {
    public static double computeRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        return 5000 / perimeter; // 5 km = 5000 meters
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three sides of triangular park in meters: ");
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();

        double rounds = computeRounds(a, b, c);
        System.out.printf("Athlete must complete %.2f rounds to run 5km%n", rounds);
    }
}
