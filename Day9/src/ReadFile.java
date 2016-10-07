import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Thu Thuy Nguyen on 03/10/2016.
 */
public class ReadFile{

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        File file = new File("fuck.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
       BufferedWriter bufferedWrite =new BufferedWriter(new FileWriter("result.txt"));
        String line;
        while ((line =bufferedReader.readLine()) != null){
            if (line.contains("fuck") || !line.startsWith("84")){
                bufferedWrite.write(line);
                bufferedWrite.newLine();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

    }
}
