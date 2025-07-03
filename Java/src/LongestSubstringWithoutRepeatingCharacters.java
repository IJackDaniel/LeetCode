// Task name: 3. Longest Substring Without Repeating Characters
// Difficulty: Medium
// Condition: Task has been solved
// Date of creation: 2025-06-08

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        var result = lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
        result = lengthOfLongestSubstring("bbbbb");
        System.out.println(result);
        result = lengthOfLongestSubstring("pwwkew");
        System.out.println(result);
    }

    static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char curChar = s.charAt(r);

            if (map.containsKey(curChar)) {
                l = Math.max(l, map.get(curChar) + 1);
            }

            map.put(curChar, r);
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
