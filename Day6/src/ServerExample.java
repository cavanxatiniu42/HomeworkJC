import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ServerExample {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1111);
        while (true) {
            serverSocket.accept();
            Socket clientSocket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());

            String fileName = dataInputStream.readUTF();
            File file = new File(fileName);
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file,true));
            DataOutputStream dataOutputStream1 = new DataOutputStream(clientSocket.getOutputStream());
            String[] chars = {"?", "/", "*", ":", "<", ">"};
            for (String aChar : chars) {
                if (fileName.contains(aChar)) {
                    dataOutputStream.close();
                }
            }
            int readed;
            while ( (readed = dataInputStream.read()) != -1) {
                dataOutputStream.write(readed);
                dataOutputStream.flush();
            }
            dataOutputStream1.writeUTF(file.getAbsolutePath() + "\n");
            dataOutputStream1.flush();
            dataOutputStream.close();
            dataOutputStream1.close();

        }

    }
}
