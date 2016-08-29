import java.io.*;
import java.security.SecureRandom;
import java.util.ArrayList;

public class JoinFile {
    public boolean joinFile (ArrayList<String> path,String pathBigFile, int numberOfFile) throws IOException {
        File newFile = new File(pathBigFile);
        for (int i = 0; i <numberOfFile ; i++) {
            File file = new File(path.get(i));
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(path.get(i)));
            byte[] bytes = new byte[(int) file.length()];
            inputStream.read(bytes);
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(newFile));
            outputStream.write(bytes);
            outputStream.close();
        }
        return true;
    }
}
