import sun.misc.IOUtils;

import java.io.*;
import java.net.Socket;

public class ClientExample {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.6.111", 1300);
        File file = new File("text.txt");
        DataInputStream inputStream = new DataInputStream(new FileInputStream(file));
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF(file.getName());
        dataOutputStream.writeUTF("\n");
        int readed;
        while ((readed = inputStream.read()) != -1){
            dataOutputStream.write( readed);
            dataOutputStream.flush();
        }
        dataOutputStream.close();
    }
}
