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

    }

    static int myAtoi(String s) {
        boolean isReading = false, isNegative = false;
        int result = 0;
        long curr = 0;

        for (int i = 0; i < s.length(); i++) {
            char symb = s.charAt(i);
            if (symb == ' ') {
                if (isReading) break;
                continue;
            } else if (symb == '+') {
                if (isReading) break;
                isReading = true;
            } else if (symb == '-') {
                if (isReading) break;
                isNegative = true;
                isReading = true;
            } else if (Character.isDigit(symb)){
                curr = (Math.abs((long)result)) * 10 + Integer.parseInt(String.valueOf(symb));
                curr = isNegative? -curr : curr;
                if (curr > 2147483647) {
                    result = 2147483647;
                    break;
                } else if (curr < -2147483648) {
                    result = -2147483648;
                    break;
                } else {
                    result = (int)(curr);
                }
                isReading = true;
            } else {
                break;
            }
        }
        return result;
    }
}