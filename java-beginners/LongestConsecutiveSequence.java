import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Array ke saare numbers HashSet me daalo
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Har number ko check karo
        for (int num : set) {

            // Agar num-1 nahi hai, to ye sequence ka starting point hai
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                // Next consecutive numbers check karo
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        int answer = longestConsecutive(nums);

        System.out.println("Longest Consecutive Sequence Length: " + answer);
    }
}