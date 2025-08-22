// Task name: 34. Find First and Last Position of Element in Sorted Array
// Difficulty: Medium
// Condition: Task has been solved
// Date of creation: 2025-08-22

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        var result = searchRange(new int[] {5,7,7,8,8,10}, 8);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
        result = searchRange(new int[] {5,7,7,8,8,10}, 6);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
        result = searchRange(new int[] {}, 0);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
        result = searchRange(new int[] {1,2}, 1);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
        result = searchRange(new int[] {1}, 0);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
        result = searchRange(new int[] {1}, 1);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
        result = searchRange(new int[] {2, 2}, 1);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1, -1};

        int[] result = new int[] {-1, -1};
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if ((left >= 0 && left < nums.length) && nums[left] == target) result[0] = left;

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if ((right >= 0 && right < nums.length) && nums[right] == target) result[1] = right;
        return result;
    }
}