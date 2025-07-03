// Task name: 1. Two Sum
// Difficulty: Easy
// Condition: Task has been solved
// Date of creation: 2025-07-03

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
        result = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
        result = twoSum(new int[]{3, 3}, 6);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{0, 0};
    }
}