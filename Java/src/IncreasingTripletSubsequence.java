// Task name: 334. Increasing Triplet Subsequence
// Difficulty: Medium
// Status: Solved
// Date of creation: 2025-12-26

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        boolean result = increasingTriplet(new int[] {1,2,3,4,5});
        System.out.println(result);
        result = increasingTriplet(new int[] {5,4,3,2,1});
        System.out.println(result);
        result = increasingTriplet(new int[] {2,1,5,0,4,6});
        System.out.println(result);
        result = increasingTriplet(new int[] {20,100,10,12,5,13});
        System.out.println(result);
    }

    static boolean increasingTriplet(int[] nums) {
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int elem = nums[i];
            if (elem <= firstMin) {
                firstMin = elem;
            } else if (elem <= secondMin) {
                secondMin = elem;
            } else {
                return true;
            }
        }
        return false;
    }
}
