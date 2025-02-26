package bigbigbai._16_dp._01_dp2;

/**
 * https://leetcode.cn/problems/coin-change/description/
 * @author: Dal
 */
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange4(new int[]{3,8}, 13));
    }

    /**
     * LC322
     * (NB) When there is no 1 coin inside coins
     * (NB) Important
     */
    public static int coinChange4(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (i < coin) continue;
                if (dp[i - coin] == -1) continue; // (NB)
                min = Math.min(dp[i - coin], min);
            }

            if (min == Integer.MAX_VALUE) dp[i] = -1; // (NB)
            else dp[i] = min + 1;
        }

        return dp[amount];
    }

    /**
     * DP
     * Thought: Start from 1 coin to amount coin, calculate what the smallest amount needs
     */
    public static int coinChange3(int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            if (i >= 1) min = Math.min(dp[i-1], min);
            if (i >= 5) min = Math.min(dp[i-5], min);
            if (i >= 20) min = Math.min(dp[i-20], min);
            if (i >= 25) min = Math.min(dp[i-25], min);
            dp[i] = min + 1;
        }

        return dp[amount];
    }

    /**
     * Memorized Search
     */
    public static int coinChange2(int n) {
        if (n < 1) return 0;

        int[] coins = {1,20,5,25};
        int[] dp = new int[n+1];
        for (int coin : coins) {
            if (n < coin) continue;
            dp[coin] = 1;
        }

        return coinChange2(n, dp);
    }

    private static int coinChange2(int n, int[] dp) {
        if (n < 1) return Integer.MAX_VALUE;

        if (dp[n] == 0) {
            int min1 = Math.min(coinChange2(n-25, dp), coinChange2(n-20, dp));
            int min2 = Math.min(coinChange2(n-5, dp), coinChange2(n-1, dp));
            dp[n] = Math.min(min1, min2) + 1;
        }
        return dp[n];
    }

    /**
     * Recursion
     * dp(n) = min {dp(n-25), dp(n-20), dp(n-5), dp(n-1)} + 1
     */
    public static int coinChange(int n) {
        if (n < 1) return Integer.MAX_VALUE;
        if (n == 25 || n == 20 || n == 5 || n == 1) return 1;

        int min1 = Math.min(coinChange(n-25), coinChange(n-20));
        int min2 = Math.min(coinChange(n-5), coinChange(n-1));

        return Math.min(min1, min2) + 1;
    }
}
