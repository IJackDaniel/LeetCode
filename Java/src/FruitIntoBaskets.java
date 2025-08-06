// Task name: 904. Fruit Into Baskets
// Difficulty: Medium
// Condition: Task has been solved
// Date of creation: 2025-08-04
// Date of solution: 2025-08-06

import java.util.HashMap;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        var result = totalFruit(new int[] {1,2,1});
        System.out.println(result);  // 3
        result = totalFruit(new int[] {0,1,2,2});
        System.out.println(result);  // 3
        result = totalFruit(new int[] {1,2,3,2,2});
        System.out.println(result);  // 4
        result = totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4});
        System.out.println(result); // 5
        result = totalFruit(new int[] {1,0,1,4,1,4,1,2,3});
        System.out.println(result); // 5
    }

    static int totalFruit(int[] fruits) {
        int result = 0, left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) map.remove(fruits[left]);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}