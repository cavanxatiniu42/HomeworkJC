import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Ex4 {
    public int calculateFolderCapacity (String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        byte[] bytesPerRead = new byte[1024];
        Queue<Byte> byteQueue = new LinkedList<>();
        int c = 0;
        while (fileInputStream.read(bytesPerRead) != 0){
            byteQueue.addAll(bytesPerRead);
            }
        }
        return c;
    }
}
