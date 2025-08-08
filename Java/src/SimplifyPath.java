// Task name: 71. Simplify Path
// Difficulty: Medium
// Condition: Task has been solved
// Date of creation: 2025-08-08

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        var result = simplifyPath("/home/");
        System.out.println(result);
        result = simplifyPath("/home//foo/");
        System.out.println(result);
        result = simplifyPath("/home/user/Documents/../Pictures");
        System.out.println(result);
        result = simplifyPath("/../");
        System.out.println(result);
        result = simplifyPath("/.../a/../b/c/../d/./");
        System.out.println(result);
        result = simplifyPath("/a/../../b/../c//.//");
        System.out.println(result);
    }

    static String simplifyPath(String path) {
        while (path.contains("//")) path = path.replaceAll("//", "/");
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String word : arr) {
            if (word.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (word.equals(".") || word.isEmpty()) {
                continue;
            } else {
                stack.add(word);
            }
        }

        return stack.isEmpty()? "/" : "/" + String.join("/", stack);
    }
}