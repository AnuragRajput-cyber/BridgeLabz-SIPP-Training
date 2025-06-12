public class ques2 {
    public static void main(String[] args) {
        int pens=14;
        int students=3;
        int quantity = pens/students;
        int remaining=pens%students;
        System.out.println("The Pen Per Student is "+quantity+" and the remaining pen not distributed is "+remaining);
    }
}
