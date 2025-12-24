// Task name: 1431. Kids With the Greatest Number of Candies
// Difficulty: Easy
// Status: Solved
// Date of creation: 2025-12-23

import java.util.*;

public class KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        List<Boolean> result = kidsWithCandies(new int[] {2,3,5,1,3}, 3);
        System.out.println(result);
        result = kidsWithCandies(new int[] {4,2,1,1,2}, 1);
        System.out.println(result);
        result = kidsWithCandies(new int[] {12, 1, 12}, 10);
        System.out.println(result);
    }

    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>(candies.length);

        int leftBound = 0;
        for (int elem : candies) {
            leftBound = Math.max(leftBound, elem);
        }
        leftBound = leftBound - extraCandies;

        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] >= leftBound);
        }

        return result;
    }
}
