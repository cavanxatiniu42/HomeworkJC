import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Thu Thuy Nguyen on 07/10/2016.
 */
public class ReadWriteFilesUsingMultipleThreads {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);
        BlockingQueue<String> queue2 = new ArrayBlockingQueue<String>(1024);
        File file = new File("fuck");
        File[] files = file.listFiles();
        for (File file1 : files) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String line;
                    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file1))){
                        while ((line = bufferedReader.readLine()) != null){
                            queue.put(line);
                        }
                        queue.put("EOF");

                    }catch (IOException | InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
            }).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
             while (true){
                 try {
                     String line = queue.take();
                     if (line.contains("fuck")||line.startsWith("9")){
                         queue2.put(line);
                     }
                     if (line.equals("EOF")){
                         queue2.put("EOF");
                         break;
                     }
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result3.txt"))) {
                    while (true){
                        bufferedWriter.write(queue2.take());
                        bufferedWriter.newLine();
                        if (queue2.take().equals("EOF")){
                            break;
                        }
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
