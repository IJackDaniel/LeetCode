// Task name: 69. Sqrt x
// Difficulty: Easy
// Condition: Task has not been solved
// Date of creation: 2025-08-22

public class SqrtX {
    public static void main(String[] args) {
        var result = mySqrt(4);
        System.out.println(result);
        result = mySqrt(8);
        System.out.println(result);
        result = mySqrt(2147395599);
        System.out.println(result);
//        result = mySqrt();
//        System.out.println(result);
//        result = mySqrt();
//        System.out.println(result);

    }

    static int mySqrt(int x) {
        int left = 0, right = (int) Math.pow(2, 16);
        while (right - left > 1) {
            int mid = (right + left) / 2;
            long square = (long) mid * mid;
            if (square > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
}