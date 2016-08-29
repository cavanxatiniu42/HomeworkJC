import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.ArrayList;

public class JoinFile {
    public boolean joinFile (ArrayList<String> path, int numberOfFile) throws FileNotFoundException {
        for (int i = 0; i <numberOfFile ; i++) {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(path.get(i)));
            inputStream.read()

        }
    }
}
