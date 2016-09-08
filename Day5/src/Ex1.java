import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ex1 {
    public void readCharacterFromTextFile(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);

        String string;
        String newString =null;
        while ((string = bufferedReader.readLine()) != null){
            newString = newString + string;
        }
        System.out.println(newString);
        String[] array = newString.split("");

        Map<String, Integer> map = new HashMap<>();
        for (String x : array){
            if (map.containsKey(x)){
                map.put(x,map.get(x)+1);
            } else {
                map.put(x,1);
            }
        }
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " "+ entry.getValue());
        }

    }
}
