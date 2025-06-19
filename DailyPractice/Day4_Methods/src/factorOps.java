import java.util.Scanner;

public class factorOps {

    public static int[] getFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) count++;

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) factors[index++] = i;
        }
        return factors;
    }

    public static int findGreatestFactor(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) if (arr[i] > max) max = arr[i];
        return max;
    }

    public static int findSum(int[] arr) {
        int sum = 0;
        for (int x : arr) sum += x;
        return sum;
    }

    public static int findProduct(int[] arr) {
        int product = 1;
        for (int x : arr) product *= x;
        return product;
    }

    public static double productOfCubes(int[] arr) {
        double product = 1;
        for (int x : arr) {
            product *= Math.pow(x, 3);
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int[] factors = getFactors(num);
        System.out.println("Factors: ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println("\nGreatest factor: " + findGreatestFactor(factors));
        System.out.println("Sum: " + findSum(factors));
        System.out.println("Product: " + findProduct(factors));
        System.out.printf("Product of cubes: %.2f%n", productOfCubes(factors));
    }
}
