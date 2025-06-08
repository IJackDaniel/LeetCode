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
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
        {
            char currChar1 = s.charAt(i);
            if (map1.containsKey(currChar1))
            {
                if (map1.get(currChar1) != t.charAt(i)) {return false;}
            } else
            {
                map1.put(currChar1, t.charAt(i));
            }

            char currChar2 = t.charAt(i);
            if (map2.containsKey(currChar2))
            {
                if (map2.get(currChar2) != s.charAt(i)) {return false;}
            } else
            {
                map2.put(currChar2, s.charAt(i));
            }
        }

        return true;
    }
}