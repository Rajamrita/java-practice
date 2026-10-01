import java.util.*;

public class Combinations {

    public static void backtrack(
            int start,
            int n,
            int k,
            List<Integer> current,
            List<List<Integer>> result) {

        // Combination is complete
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try numbers from start to n
        for (int i = start; i <= n; i++) {

            // Choose
            current.add(i);

            // Explore
            backtrack(i + 1, n, k, current, result);

            // Undo
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(1, n, k, new ArrayList<>(), result);

        return result;
    }

    public static void main(String[] args) {

        int n = 4;
        int k = 2;

        List<List<Integer>> result = combine(n, k);

        System.out.println("All Combinations:");

        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}