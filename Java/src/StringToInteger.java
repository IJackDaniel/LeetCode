// Task name: 8. String to Integer
// Difficulty: Medium
// Condition: Task has been solved
// Date of creation: 2025-08-16

public class StringToInteger {
    public static void main(String[] args) {
        var result = myAtoi("42");
        System.out.println(result);
        result = myAtoi("   -042");
        System.out.println(result);
        result = myAtoi("1337c0d3");
        System.out.println(result);
        result = myAtoi("0-1");
        System.out.println(result);
        result = myAtoi("words and 987");
        System.out.println(result);
        result = myAtoi("-21474836482");
        System.out.println(result); // -2147483648
        result = myAtoi("9223372036854775808");
        System.out.println(result); // 2147483647
        result = myAtoi("");
        System.out.println(result);

    }

    static int myAtoi(String s) {
        if (s.isEmpty()) return 0;

        // Delete excess spaces
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n) return 0;

        // Determine sign
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // Definition of value
        final int MAX = Integer.MAX_VALUE;
        final int MIN = Integer.MIN_VALUE;
        long currentValue = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            currentValue = currentValue * 10 + digit;
            if (currentValue * sign > MAX) return MAX;
            if (currentValue * sign < MIN) return MIN;
            i++;
        }

        return (int)(currentValue * sign);
    }
}