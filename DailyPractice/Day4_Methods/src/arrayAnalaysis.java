import java.util.Scanner;

public class arrayAnalaysis {

    public static boolean isPositive(int n) {
        return n >= 0;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int compare(int a, int b) {
        if (a > b) return 1;
        else if (a < b) return -1;
        else return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
        }

        for (int n : nums) {
            if (isPositive(n)) {
                System.out.print(n + " is Positive and ");
                System.out.println(isEven(n) ? "Even" : "Odd");
            } else {
                System.out.println(n + " is Negative");
            }
        }

        int result = compare(nums[0], nums[4]);
        System.out.print("First and Last Element Comparison: ");
        if (result == 1)
            System.out.println("First is greater");
        else if (result == -1)
            System.out.println("First is less");
        else
            System.out.println("Both are equal");
    }
}
