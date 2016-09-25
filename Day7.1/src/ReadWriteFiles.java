import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ReadWriteFiles {
    public static void main(String[] args) throws FileNotFoundException {
        Queue<String> stringQueue = new LinkedList<>();
        String pathRead = "fuck.txt";
        String pathWrite = "new.txt";
        new ReadFiles(pathRead, stringQueue).start();
        new WriteFile(pathWrite,stringQueue).start();


    }
}
