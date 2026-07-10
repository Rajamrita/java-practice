import java.util.*;

public class RandomizedSet {

    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {

        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val) {

        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);

        // Replace removed element with last element
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Remove last element
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {

        RandomizedSet obj = new RandomizedSet();

        System.out.println(obj.insert(1));      // true
        System.out.println(obj.remove(2));      // false
        System.out.println(obj.insert(2));      // true
        System.out.println(obj.getRandom());    // 1 or 2
        System.out.println(obj.remove(1));      // true
        System.out.println(obj.insert(2));      // false
        System.out.println(obj.getRandom());    // 2
    }
}