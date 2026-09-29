import java.util.*;

public class Permutations {

    public static void backtrack(
            int[] nums,
            List<Integer> current,
            List<List<Integer>> result) {

        // If permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every number
        for (int num : nums) {

            // Skip if number is already used
            if (current.contains(num)) {
                continue;
            }

            // Choose
            current.add(num);

            // Recursion
            backtrack(nums, current, result);

            // Undo
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), result);

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        List<List<Integer>> result = permute(nums);

        System.out.println("All Permutations:");

        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }
}