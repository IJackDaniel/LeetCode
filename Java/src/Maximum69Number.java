// Task name: 1323. Maximum 69 Number
// Difficulty: Easy
// Condition: Task has been solved
// Date of creation: 2025-08-16

public class Maximum69Number {
    public static void main(String[] args) {
        var result = maximum69Number(9669);
        System.out.println(result);
        result = maximum69Number(9996);
        System.out.println(result);
        result = maximum69Number(9999);
        System.out.println(result);
    }

    static int maximum69Number(int num) {
        String numStr = String.valueOf(num);
        int addNum = 3 * (int)(Math.pow(10, numStr.length() - 1));

        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) != '6') {
                addNum = addNum / 10;
            } else {
                break;
            }
        }
        return num + addNum;
    }
}