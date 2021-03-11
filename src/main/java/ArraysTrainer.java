import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ArraysTrainer {

    public int[] intArray = new int[] { 1, 2, 3, 4, 8 };
    public int[] ints = new int[5];
    public int[][] intDoubleArray = new int[][]{ {1, 3, 4}, {1, 65, 7} };

    public List<Integer> intList = new ArrayList<>();
    public List<List<Integer>> intDoubleList = new ArrayList<>();

    public Map<String, Integer> intMap = new TreeMap<>();

    public void move(){

        intMap.put("first", 1);
        intMap.put("second", 20);
        intMap.put("third", 30);
        intMap.put("fourth", 15);
        intMap.put("another", 10);

        intMap.get("first");

        for (String key : intMap.keySet()){
            System.out.println(key + ": "+ intMap.get(key));
        }
    }


}
