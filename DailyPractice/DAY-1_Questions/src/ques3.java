import java.util.*;
public class ques3 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int Height = sc.nextInt();
        float inches = Height/2.84F;
        float foot = Height/30.48F;
        System.out.println("Your Height in cm is "+Height+" while in feet is "+ foot+ "and inches is "+inches);
    }
}
