// Task name: 33. Search in Rotated Sorted Array
// Difficulty: Medium
// Condition: Task has not been solved
// Date of creation: 2025-08-21

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        var result = search(new int[] {4,5,6,7,0,1,2}, 0);
        System.out.println(result);
        result = search(new int[] {4,5,6,7,0,1,2}, 3);
        System.out.println(result);
        result = search(new int[] {1}, 0);
        System.out.println(result);

        result = search(new int[] {3,5,1}, 3);
        System.out.println(result); // 0
        result = search(new int[] {4,5,6,7,0,1,2}, 2);
        System.out.println(result); // 6
    }
    static int binSearch(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (array[middle] > array[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;

    }

    static int search(int[] nums, int target) {
        int rotationIndex = binSearch(nums);
        int left = 0, right = nums.length - 1;
        if (rotationIndex != 0 && target >= nums[0] && target <= nums[rotationIndex - 1]) {
            right = rotationIndex - 1;
        } else if (rotationIndex == 0 || target >= nums[rotationIndex] && target <= nums[nums.length - 1]) {
            left = rotationIndex;
        } else {
            return -1;
        }

        while (left < right) {
            int current = left + (right - left) / 2;
            if (nums[current] == target) {
                return current;
            } else if (nums[current] < target){
                left = current + 1;
            } else {
                right = current - 1;
            }
        }

        if (nums[left] == target) return left;
        else return -1;
    }
}