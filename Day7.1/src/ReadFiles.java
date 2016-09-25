import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Thu Thuy Nguyen on 25/09/2016.
 */
public class ReadFiles extends Thread{
    private String path;
    private Queue<String> stringQueue= new LinkedList<>();
    File file = new File(path);

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    public ReadFiles  (String path, Queue<String> stringQueue) throws FileNotFoundException {
        this.path = path;
        this.stringQueue = stringQueue;
    }
    String line;

    @Override
    public void run() {
        try {
            while ((line = bufferedReader.readLine()) != null){
                if (line.contains("fuck")){
                   stringQueue.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
