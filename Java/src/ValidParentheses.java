// Task name: 20. Valid Parentheses
// Difficulty: Easy
// Condition: Task has been solved
// Date of creation: 2025-08-04

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        var result = isValid("()[]{}");
        System.out.println(result);
        result = isValid("(]");
        System.out.println(result);
        result = isValid("([])");
        System.out.println(result);
        result = isValid("([)]");
        System.out.println(result);
        result = isValid("]");
        System.out.println(result);
    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char elem : s.toCharArray()) {
            if (elem == '(' || elem == '[' || elem == '{') {
                stack.add(elem);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if ((int)stack.lastElement() + 1 == (int)elem || (int)stack.lastElement() + 2 == (int)elem) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}