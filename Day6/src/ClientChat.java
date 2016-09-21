import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Socket socket = new Socket("localhost", 1200);
        System.out.print("Enter name: ");
        String name = input.nextLine();
          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        while (true){
        String message = input.nextLine();
            while ((bufferedReader.readLine()) != null) {
                System.out.println(bufferedReader.readLine());
            }
            printWriter.println(name + ": "+message);
            printWriter.flush();
        }
    }
}
