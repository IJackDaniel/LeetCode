// Task name: 345. Reverse Vowels of a String
// Difficulty: Easy
// Status: Solved
// Date of creation: 2025-12-24

import java.util.ArrayList;
import java.util.List;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        String result = reverseVowels("IceCreAm");
        System.out.println(result);
        result = reverseVowels("leetcode");
        System.out.println(result);
    }

    static String reverseVowels(String s) {
        boolean[] isVowel = new boolean[128];
        for (char ch : "aeiouAEIOU".toCharArray()) isVowel[ch] = true;

        int left = 0, right = s.length() - 1;
        char[] string = s.toCharArray();
        while (right > left) {
            while (right > left && !isVowel[s.charAt(left)]) left++;
            while (right > left && !isVowel[s.charAt(right)]) right--;

            if (isVowel[s.charAt(left)] && isVowel[s.charAt(right)]) {
                char save = string[left];
                string[left] = string[right];
                string[right] = save;
                left++;
                right--;
            }
        }
        return String.valueOf(string);
    }
}
