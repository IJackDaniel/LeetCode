// Task name: 605. Can Place Flowers
// Difficulty: Easy
// Status: Solved
// Date of creation: 2025-12-24

public class CanPlaceFlowers {
    public static void main(String[] args) {
        boolean result = canPlaceFlowers(new int[] {1,0,0,0,1}, 1);
        System.out.println(result);
        result = canPlaceFlowers(new int[] {1,0,0,0,1}, 2);
        System.out.println(result);
    }

    static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n == 0;
    }
}
