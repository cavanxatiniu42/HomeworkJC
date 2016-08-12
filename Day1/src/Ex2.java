import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        int[] array = new int[10];
        Scanner input = new Scanner(System.in);
        try{
            for (int i =0;i < 10; i++) {
                System.out.println("Input the index: ");
                i = input.nextInt();
                System.out.println("Input the value: ");
                array[i] = input.nextInt();
            }

        }catch (IndexOutOfBoundsException ex){
            System.out.println("index out of bound");
        }
    }
}
