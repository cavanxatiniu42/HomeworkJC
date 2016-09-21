import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ServerChat {
    static List<Socket> socketList;
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(1200);
        socketList= new LinkedList<>();
        System.out.println("connecting.....");
        while (true){
            serverSocket.accept();
            Socket clientSocket = serverSocket.accept();
            socketList.add(clientSocket);
            System.out.println("connected.");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = bufferedReader.readLine();
            for (Socket socket: socketList) {
//                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//                bufferedWriter.write(message);
//                bufferedWriter.flush();
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.println(message);
                printWriter.flush();
            }
        }
    }
}
