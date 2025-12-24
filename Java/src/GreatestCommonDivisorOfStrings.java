// Task name: 1071. Greatest Common Divisor of Strings
// Difficulty: Easy
// Status: Solved
// Date of creation: 2025-12-23

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        String result = gcdOfStrings("ABCABC", "ABC");
        System.out.println(result);
        result = gcdOfStrings("ABABAB", "ABAB");
        System.out.println(result);
        result = gcdOfStrings("LEET", "CODE");
        System.out.println(result);
        result = gcdOfStrings("AAAAAB", "AAA");
        System.out.println(result);
        result = gcdOfStrings("ABABABAB", "ABAB");
        System.out.println(result);
    }

    static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";

        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    static int gcd(int num1, int num2) {
        return num2 == 0 ? num1 : gcd(num2, num1 % num2);
    }

    static String gcdOfStringsBruteForce(String str1, String str2) {
        String result = "";
        StringBuilder prefix = new StringBuilder(str1.length());
        for (char symb : str1.toCharArray()) {
            prefix.append(symb);
            String current = prefix.toString();
            if (str1.replace(current, "").isEmpty() && str2.replace(current, "").isEmpty()) {
                result = current;
            }
        }
        return result;
    }
}
