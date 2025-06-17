import java.util.Scanner;
public class youngestOrTallestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ages of Amar, Akbar, Anthony: ");
        int amar = sc.nextInt();
        int akbar = sc.nextInt();
        int anthony = sc.nextInt();

        System.out.print("Enter heights of Amar, Akbar, Anthony: ");
        int h1 = sc.nextInt();
        int h2 = sc.nextInt();
        int h3 = sc.nextInt();

        String youngest = (amar < akbar && amar < anthony) ? "Amar" :
                (akbar < anthony) ? "Akbar" : "Anthony";

        String tallest = (h1 > h2 && h1 > h3) ? "Amar" :
                (h2 > h3) ? "Akbar" : "Anthony";

        System.out.println("Youngest: " + youngest);
        System.out.println("Tallest: " + tallest);
    }
}
