import java.util.*;

public class Parentheses {

    public static void backtrack(
            int n,
            int open,
            int close,
            String current,
            List<String> result) {

        // If all brackets are used
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add opening bracket
        if (open < n) {
            backtrack(
                    n,
                    open + 1,
                    close,
                    current + "(",
                    result
            );
        }

        // Add closing bracket
        if (close < open) {
            backtrack(
                    n,
                    open,
                    close + 1,
                    current + ")",
                    result
            );
        }
    }

    public static List<String> generateParentheses(int n) {

        List<String> result = new ArrayList<>();

        backtrack(
                n,
                0,
                0,
                "",
                result
        );

        return result;
    }

    public static void main(String[] args) {

        int n = 3;

        List<String> result = generateParentheses(n);

        System.out.println("Valid Parentheses:");

        for (String combination : result) {
            System.out.println(combination);
        }
    }
}