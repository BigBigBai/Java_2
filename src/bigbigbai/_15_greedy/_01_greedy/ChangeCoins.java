package bigbigbai._15_greedy._01_greedy;

import java.util.Arrays;

public class ChangeCoins {
    public static void main(String[] args) {
        System.out.println("total: " + changeCoins(new int[]{1,10,5,25}, 41));
        System.out.println("total: " + changeCoins(new int[]{1,10,5,20,25}, 41)); // 20 20 1
    }

    public static int changeCoins(int[] coins, int money) {
        Arrays.sort(coins);
        int total = 0;
        for (int i = coins.length - 1; i >= 0;) {
            if (money < coins[i]) {
                i--;
                continue;
            }
            money -= coins[i];
            System.out.print(coins[i] + " ");
            total++;

        }
        return total;
    }
}
