// Task name: 81. Search in Rotated Sorted Array II
// Difficulty: Medium
// Condition: Task has not been solved
// Date of creation: 2025-08-30

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        var result = search(new int[] {2,5,6,0,0,1,2}, 0);
        System.out.println(result);
        result = search(new int[] {2,5,6,0,0,1,2}, 3);
        System.out.println(result);
    }

    static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
        if (target > nums[left] && target < nums[nums.length-1]) {
            right = nums.length-1;
        } else if (target > nums[0] && target < nums[left-1]) {
            right = left - 1;
            left = 0;
        }

        while (left < right) {
            int current = left + (right - left) / 2;
            if (nums[current] == target) {
                return true;
            } else if (nums[current] < target){
                left = current + 1;
            } else {
                right = current - 1;
            }
        }
        if (nums[left] == target) return true;
        return false;
    }
}