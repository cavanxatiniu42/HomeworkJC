import java.util.Arrays;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char choice = 0;
        String operation = input.nextLine();
        try {
        for (int i = 0; i <operation.length() ; i++) {
            if (operation.charAt(i) == '+' || operation.charAt(i) == '-' || operation.charAt(i) == 'x' || operation.charAt(i) == ':') {
                choice = operation.charAt(i);

            }
        }
            String a = String.valueOf(choice);

            String[] array = operation.split(a);

            System.out.println(Arrays.toString(array));

            int number1 = Integer.parseInt(array[0]);
            int number2 = Integer.parseInt(array[1]);
            if (choice == '+'){
                System.out.println("result: " + (number1 + number2));
            } else if (choice == '-'){
                System.out.println("result: " + (number1-number2));
            } else if (choice == 'x'){
                System.out.println("result: " + (number1 * number2));
            } else if (choice == ':'){
                System.out.println("result: " + (number1/number2));
            }

        }catch (Exception ex){
            System.out.println("đéo ra");
        }

    }
}
