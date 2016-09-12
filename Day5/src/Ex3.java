import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex3 {
    public ArrayList<Character> removeDuplicate(ArrayList<Character> list){
        Map<Character, Integer> newMap = new HashMap<>();
        for (char x : list){
                System.out.println(newMap.get(x));
            if (newMap.containsKey(x)){
                newMap.put(x, newMap.get(x)+1);
        } else {
            newMap.put(x,1);
            }
        }
        ArrayList<Character> newList = new ArrayList<>();
        Set<Character> set = newMap.keySet();
        for (Character character : set) {
            newList.add(character);
        }
        return newList;
//        newMap.get
    }
}
