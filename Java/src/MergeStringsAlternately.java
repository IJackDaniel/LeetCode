// Task name: 1768. Merge Strings Alternately
// Difficulty: Easy
// Condition: Task has been solved
// Date of creation: 2025-12-19

public class MergeStringsAlternately {
    public static void main(String[] args) {
        var result = mergeAlternately("abc", "pqr");
        System.out.println(result);
        result = mergeAlternately("ab", "pqrs");
        System.out.println(result);
    }

    static String mergeAlternately(String word1, String word2) {
        int i = 0;
        int n = Math.max(word1.length(), word2.length());
        StringBuilder result = new StringBuilder(word1.length() + word2.length());
        while (i < n) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
            i = i + 1;
        }
        return result.toString();
    }
}