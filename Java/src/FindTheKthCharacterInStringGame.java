// Task name: 3304. Find the Kth Character in String Game
// Difficulty: Easy
// Condition: Task has been solved
// Date of creation: 2025-07-03

public class FindTheKthCharacterInStringGame {
    public static void main(String[] args) {
        var result = kthCharacter(5);
        System.out.println(result);
        result = kthCharacter(10);
        System.out.println(result);
        result = kthCharacter(1);
        System.out.println(result);
        result = kthCharacter(2);
        System.out.println(result);
    }

    static char kthCharacter(int k) {
        String gameString = "a";
        int iterBorder = (int)Math.ceil(Math.log(k) / Math.log(2));

        for (int i = 1; i <= iterBorder; i++) {
            String newString = "";
            for (int j = 0; j < gameString.length(); j++) {
                char el = gameString.charAt(j);
                newString = newString + (char)((int)el + 1);
            }
            gameString = gameString + newString;
        }

        return gameString.charAt(k - 1);
    }
}