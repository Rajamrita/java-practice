import java.util.Stack;
public class ValidParentheses {
    public static void main(String[] args) {
        String str = "()[]{}";
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    System.out.println("Invalid Parentheses");
                    return;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
                    System.out.println("Invalid Parentheses");
                    return;
                }
            }
            
        }
        if (!stack.isEmpty()) {
            System.out.println("valid");
        } else {
            System.out.println("Invalid");
        }
    }

    
}
