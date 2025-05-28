// Task name: 13. Roman to Integer
// Difficulty: Easy
// Condition: Task has been solved
// Date of creation: 2025-05-28

public class Roman_to_Integer {
    public static void main(String[] args) {
        var result = romanToInt("III");
        System.out.println(result);
        result = romanToInt("LVIII");
        System.out.println(result);
        result = romanToInt("MCMXCIV");
        System.out.println(result);
    }

    public static int romanToInt(String s) {
        char[] letters = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] numbers = {1, 5, 10, 50, 100, 500, 1000};

        char[] input = s.toCharArray();
        int[] numericalEquivalent = new int[s.length()];
        int j;
        for (int i = 0; i < input.length; i++) {
            for (j = 0; j <= numbers.length; j++) {
                if (input[i] == letters[j]) {
                    break;
                }
            }
            numericalEquivalent[i] = numbers[j];
        }

        int result = numericalEquivalent[input.length - 1];
        for (int i = 0; i < input.length - 1; i++) {
            if (numericalEquivalent[i] < numericalEquivalent[i + 1]) {
                result = result - numericalEquivalent[i];
            } else {
                result = result + numericalEquivalent[i];
            }

        }

//        System.out.println(Arrays.toString(arr));
        return result;
    }
}