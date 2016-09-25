import java.io.*;
import java.util.Queue;

/**
 * Created by Thu Thuy Nguyen on 25/09/2016.
 */
public class WriteFile extends Thread{
    private Queue<String> stringQueue;
    private String pathWrite;
    BufferedWriter bufferedWriter;
    public WriteFile (String pathWrite, Queue<String> stringQueue) throws FileNotFoundException {
        this.pathWrite = pathWrite;
        this.stringQueue = stringQueue;
        File file = new File(pathWrite);
        new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
    }

    @Override
    public void run() {
        try {
            while (stringQueue.poll() != null) {
                bufferedWriter.write(stringQueue.poll());
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
