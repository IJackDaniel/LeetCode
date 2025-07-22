// Task name: 1695. Maximum Erasure Value
// Difficulty: Medium
// Condition: Task has been solved
// Date of creation: 2025-07-22

import java.util.*;

public class MaximumErasureValue {
    public static void main(String[] args) {
        var result = maximumUniqueSubarray(new int[] {4,2,4,5,6});
        System.out.println(result);
        result = maximumUniqueSubarray(new int[] {5,2,1,2,5,2,1,2,5});
        System.out.println(result);
    }

    static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxSum = 0, currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                currentSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            set.add(nums[right]);
            currentSum += nums[right];

            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}