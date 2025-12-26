// Task name: 238. Product of Array Except Self
// Difficulty: Medium
// Status: Solved
// Date of creation: 2025-12-26

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] result = productExceptSelf(new int[] {1,2,3,4});
        System.out.println(Arrays.toString(result));
        result = productExceptSelf(new int[] {-1,1,0,-3,3});
        System.out.println(Arrays.toString(result));
        result = productExceptSelf(new int[] {0, 1, 1, 0, 2});
        System.out.println(Arrays.toString(result));
    }

    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int product = 1, countOfZero = 0, indexLastZero = -1;
        for (int i = 0; i < n; i++) {
            int elem = nums[i];
            if (elem != 0) product = product * elem;
            else {
                countOfZero++;
                indexLastZero = i;
            }
        }

        if (countOfZero > 1) nums = new int[n];
        else if (countOfZero == 1)  {
            nums = new int[n];
            nums[indexLastZero] = product;
        }
        else {
            for (int j = 0; j < n; j++) {
                nums[j] = product / nums[j];
            }
        }

        return nums;
    }
}
