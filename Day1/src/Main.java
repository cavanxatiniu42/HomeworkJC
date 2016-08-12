import java.util.Scanner;

/**
 * Created by Thu Thuy Nguyen on 13/08/2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input 3 sides");
        try {
            double side1 = input.nextDouble();
            double side2 = input.nextDouble();
            double side3 = input.nextDouble();
            Triangle2 triangle = new Triangle2(side1,side2,side3);
            System.out.println("hi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
