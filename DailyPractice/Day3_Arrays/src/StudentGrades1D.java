import java.util.*;

public class StudentGrades1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] phy = new int[n], chem = new int[n], math = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i+1));
            System.out.print("Physics: ");
            phy[i] = sc.nextInt();
            System.out.print("Chemistry: ");
            chem[i] = sc.nextInt();
            System.out.print("Math: ");
            math[i] = sc.nextInt();

            int total = phy[i] + chem[i] + math[i];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 90) grade[i] = 'A';
            else if (percentage[i] >= 75) grade[i] = 'B';
            else if (percentage[i] >= 60) grade[i] = 'C';
            else if (percentage[i] >= 45) grade[i] = 'D';
            else grade[i] = 'F';
        }

        System.out.println("\nResults:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i+1) + ": Physics=" + phy[i] + ", Chemistry=" + chem[i] + ", Math=" + math[i] +
                    ", Percentage=" + percentage[i] + "%, Grade=" + grade[i]);
        }
    }
}
