// Task name: 852. Peak Index in a Mountain Array
// Difficulty: Medium
// Condition: Task has been solved
// Date of creation: 2025-08-23

public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        var result = peakIndexInMountainArray(new int[] {0,1,0});
        System.out.println(result);
        result = peakIndexInMountainArray(new int[] {0,2,1,0});
        System.out.println(result);
        result = peakIndexInMountainArray(new int[] {0,10,5,2});
        System.out.println(result);
        result = peakIndexInMountainArray(new int[] {3,5,3,2,0});
        System.out.println(result);
        result = peakIndexInMountainArray(new int[] {10, 4, 2, 1});
        System.out.println(result);
        result = peakIndexInMountainArray(new int[] {0, 4, 6, 8});
        System.out.println(result);
//        result = peakIndexInMountainArray(new int[] {});
//        System.out.println(result);
    }

    static int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) {
                return mid;
            } else if (arr[mid] < arr[mid+1]) {
                left = mid;
            } else if (arr[mid] < arr[mid-1]) {
                right = mid;
            }
        }
        return left;
    }
}