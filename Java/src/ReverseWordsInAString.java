// Task name: 151. Reverse Words in a String
// Difficulty: Medium
// Status: Solved
// Date of creation: 2025-12-24

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String result = reverseWords("the sky is blue");
        System.out.println(result);
        result = reverseWords("  hello world  ");
        System.out.println(result);
        result = reverseWords("a good   example");
        System.out.println(result);

    }

    static String reverseWords(String s) {
        String[] words = (s.trim()).replaceAll("[\\s]{2,}", " ").split(" ");

        StringBuilder stringBuilder = new StringBuilder(s.length());
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            stringBuilder.append(word).append(" ");
        }

        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
