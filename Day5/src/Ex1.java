import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Ex1 {
    public void readCharacterFromTextFile(String path) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String string;
        Map<Character, Integer> map = new HashMap<>();
        while ((string = bufferedReader.readLine()) != null){
           char[] array = string.toCharArray();
        for (char x : array){
            if (map.containsKey(x)){
                map.put(x,map.get(x)+1);
            } else {
                map.put(x,1);
            }
        }
        }

        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " "+ entry.getValue());
        }

    }
}
