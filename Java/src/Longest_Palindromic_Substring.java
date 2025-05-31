// Task name: 5. Longest Palindromic Substring
// Difficulty: Medium
// Condition: Task has not been solved
// Date of creation: 2025-05-31

public class Longest_Palindromic_Substring
{
    public static void main(String[] args)
    {
        var result = longestPalindrome("babad");
        System.out.println(result);
        result = longestPalindrome("cbbd");
        System.out.println(result);
        result = longestPalindrome("a");
        System.out.println(result);
        result = longestPalindrome("abcba");
        System.out.println(result);
    }

    static String longestPalindrome(String str)
    {
        // Manaker algorithm
        String[] charsArray = str.split("");
        String s = "^#" + String.join("#", charsArray) + "#$";

        int center = 0, rightBorder = 0, n = s.length();
        int[] radius = new int[n];

        for (int i = 1; i < n - 1; i++)
        {
            int mirror = 2 * center - i;

            if (i < rightBorder)
            {
                radius[i] = Math.min(rightBorder - i, radius[mirror]);
            }

            while (i + radius[i] + 1 < n && i - radius[i] - 1 >= 0
                    && s.charAt(i + radius[i] + 1) == s.charAt(i - radius[i] - 1))
            {
                radius[i]++;
            }

            if (i + radius[i] > rightBorder)
            {
                center = i;
                rightBorder = i + radius[i];
            }
        }

        // find max pallindrom
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++)
        {
            if (radius[i] > maxLen)
            {
                maxLen = radius[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen - 1) / 2;
        return str.substring(start, start + maxLen);
    }
}