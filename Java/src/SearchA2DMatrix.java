// Task name: 74. Search a 2D Matrix
// Difficulty: Medium
// Condition: Task has been solved
// Date of creation: 2025-08-29

public class SearchA2DMatrix {
    public static void main(String[] args) {
        var result = searchMatrix(new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 3);
        System.out.println(result);
        result = searchMatrix(new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 13);
        System.out.println(result);
        result = searchMatrix(new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 34);
        System.out.println(result);
        result = searchMatrix(new int[][] {{1}}, 0);
        System.out.println(result);
        result = searchMatrix(new int[][] {{1}}, 1);
        System.out.println(result);
        result = searchMatrix(new int[][] {{1}}, 2);
        System.out.println(result);
        result = searchMatrix(new int[][] {{1}, {3}}, 1);
        System.out.println(result);
        result = searchMatrix(new int[][] {{1}, {3}, {5}}, 3);
        System.out.println(result);
        result = searchMatrix(new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 11);
        System.out.println(result);
        result = searchMatrix(new int[][] {{-9,-8,-8,-8}, {-7,-6,-5,-5}, {-3,-1,0,0}, {2,3,4,5}, {7,7,7,7}, {9,9,10,10}}, 10);
        System.out.println(result);
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        int mid_row = 0;
        int left = 0, right = matrix.length - 1;
        if (matrix.length != 1) {
            while (left <= right) {
                mid_row = (left + right) / 2;
                if (matrix[mid_row][0] >= target) {
                    if (matrix[mid_row][0] == target) return true;
                    right = mid_row - 1;
                } else {
                    left = mid_row + 1;
                }
            }
            mid_row = right > -1 ? right : 0;
            left = 0;
            right = matrix[mid_row].length - 1;
        }
        right = matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid_row][mid] == target) {
                return true;
            } else if (matrix[mid_row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < matrix[mid_row].length && matrix[mid_row][left] == target) return true;
        return false;
    }
}