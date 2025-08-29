// Task name: 162. Find Peak Element
// Difficulty: Medium
// Condition: Task has been solved
// Date of creation: 2025-08-29

public class FindPeakElement {
    public static void main(String[] args) {
        var result = findPeakElement(new int[] {1,2,3,1});
        System.out.println(result);
        result = findPeakElement(new int[] {1,2,1,3,5,6,4});
        System.out.println(result);
        result = findPeakElement(new int[] {5,2,3,1});
        System.out.println(result);
        result = findPeakElement(new int[] {1,5,3,1});
        System.out.println(result);
        result = findPeakElement(new int[] {1,2,3,5});
        System.out.println(result);
        result = findPeakElement(new int[] {1,2});
        System.out.println(result);
    }

    static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;

        int left = 1, right = nums.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            else if (nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[0] > nums[1] ? 0 : nums.length - 1;
    }
}