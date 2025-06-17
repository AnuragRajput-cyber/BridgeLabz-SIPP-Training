import java.util.*;

public class studentGrade2d {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i+1));
            for (int j = 0; j < 3; j++) {
                System.out.print("Subject " + (j+1) + ": ");
                int m = sc.nextInt();
                if (m < 0) {
                    j--;
                    continue;
                }
                marks[i][j] = m;
            }

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 90) grade[i] = 'A';
            else if (percentage[i] >= 75) grade[i] = 'B';
            else if (percentage[i] >= 60) grade[i] = 'C';
            else if (percentage[i] >= 45) grade[i] = 'D';
            else grade[i] = 'F';
        }

        System.out.println("\nStudent Marks, Percentage and Grade:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i+1) + ": " + Arrays.toString(marks[i]) +
                    ", Percentage: " + percentage[i] + "%, Grade: " + grade[i]);
        }
    }
}
