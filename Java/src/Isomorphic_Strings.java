// Task name: 205. Isomorphic Strings
// Difficulty: Easy
// Condition: Task has been solved
// Date of creation: 2025-06-08

import java.util.HashMap;

public class Isomorphic_Strings {
    public static void main(String[] args) {
        var result = isIsomorphic("egg", "add");
        System.out.println(result);
        result = isIsomorphic("foo", "bar");
        System.out.println(result);
        result = isIsomorphic("paper", "title");
        System.out.println(result);
    }

    static boolean isIsomorphic(String s, String t)
    {
        if (s.length() != t.length()) {return false;}

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++)
        {
            char curCharS = s.charAt(i);
            char curCharT = t.charAt(i);

            if (mapS[curCharS] != mapT[curCharT])
            {
                return false;
            }

            mapS[curCharS] = i + 1;
            mapT[curCharT] = i + 1;
        }
        return true;
    }
}