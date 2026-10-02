import java.util.*;

public class LetterCombinations {

    private static final String[] MAPPING = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        backtrack(
            digits,
            0,
            new StringBuilder(),
            result
        );

        return result;
    }

    private static void backtrack(
            String digits,
            int index,
            StringBuilder current,
            List<String> result) {

        // If all digits are processed
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for current digit
        String letters =
            MAPPING[digits.charAt(index) - '0'];

        // Try every letter
        for (int i = 0; i < letters.length(); i++) {

            // Choose
            current.append(letters.charAt(i));

            // Explore
            backtrack(
                digits,
                index + 1,
                current,
                result
            );

            // Undo
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {

        String digits = "23";

        List<String> result =
            letterCombinations(digits);

        System.out.println("Letter Combinations:");

        System.out.println(result);
    }
}