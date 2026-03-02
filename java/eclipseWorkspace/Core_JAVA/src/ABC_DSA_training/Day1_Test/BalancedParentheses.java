package ABC_DSA_training.Day1_Test;

import java.util.*;

public class BalancedParentheses {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                	return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner (System.in);
    	System.out.println("Enter the expression : ");
        String expr = sc.nextLine();
        System.out.println("Expression: " + expr);
        System.out.println("Is Balanced? " + isBalanced(expr));
        sc.close();
    }
}