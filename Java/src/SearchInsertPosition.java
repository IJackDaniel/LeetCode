// Task name: 35. Search Insert Position
// Difficulty: Easy
// Condition: Task has been solved
// Date of creation: 2025-08-23

public class SearchInsertPosition {
    public static void main(String[] args) {
        var result = searchInsert(new int[] {1,3,5,6}, 5);
        System.out.println(result);
        result = searchInsert(new int[] {1,3,5,6}, 2);
        System.out.println(result);
        result = searchInsert(new int[] {1,3,5,6}, 7);
        System.out.println(result);
        result = searchInsert(new int[] {1, 3}, 2);
        System.out.println(result);
//        result = searchInsert(new int[] {}, 0);
//        System.out.println(result);
    }

    static int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        if (target > nums[nums.length-1]) return nums.length;
        int left = 0, right = nums.length - 1 ;
        while (right - left >= 1) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target && nums[mid-1] < target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}