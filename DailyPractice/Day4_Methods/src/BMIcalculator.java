import java.util.Scanner;

public class BMIcalculator {

    public static void calculateBMI(double[][] members) {
        for (int i = 0; i < members.length; i++) {
            double weight = members[i][0];
            double heightInMeters = members[i][1] / 100;
            double bmi = weight / (heightInMeters * heightInMeters);
            members[i][2] = bmi;
        }
    }

    public static String getStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] members = new double[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            members[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            members[i][1] = sc.nextDouble();
        }

        calculateBMI(members);

        System.out.println("\nIndex\tWeight\tHeight\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.1f\t%.1f\t%.2f\t%s%n", i + 1, members[i][0], members[i][1], members[i][2], getStatus(members[i][2]));
        }
    }
}
