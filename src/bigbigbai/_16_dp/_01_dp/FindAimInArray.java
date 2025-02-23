package bigbigbai._16_dp._01_dp;

public class FindAimInArray {
    public static void main(String[] args) {
        System.out.println(findAimInArray2(new int[]{2,3,5}, 9));
        System.out.println(findAimInArray3(new int[]{2,3,5}, 9));
    }

    /**
     * DP
     * @author: Dal
     */
    public static boolean findAimInArray3(int[] arr, int aim) {
        boolean[][] dp = new boolean[arr.length+1][aim+1];
        for (int i = 0; i < dp.length; i++) dp[i][aim] = true;

        for(int i = arr.length - 1; i >= 0; i--) {
            for(int j = aim - 1; j >= 0; j--) {
                dp[i][j] = dp[i+1][j];
                if (j + arr[i] <= aim) dp[i][j] = dp[i+1][j] || dp[i+1][j+arr[i]];
            }
        }

        return dp[0][0];
    }

    /**
     * DP
     * @author: BigBigBai
     */
    public static boolean findAimInArray2(int[] arr, int aim) {
        boolean[][] dp = new boolean[arr.length+1][aim+1];
        for(int i = 0; i < dp.length; i++) dp[i][0] = true;

        for(int i = 1; i < arr.length + 1; i++) {
            for(int j = 1; j < aim + 1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - arr[i-1] >= 0) dp[i][j] = dp[i-1][j] || dp[i - 1][j - arr[i-1]];
            }
        }

        return dp[arr.length][aim];
    }


    /**
     * Recursion
     */
    public static boolean findAimInArray(int[] arr, int aim) {
        return findAimInArray(arr, aim, 0, 0);
    }

    private static boolean findAimInArray(int[] arr, int aim, int index, int sum) {
        if (sum == aim) return true;
        if (index == arr.length) return false;

        return findAimInArray(arr, aim, index+1, sum) || findAimInArray(arr, aim, index+1, sum+arr[index]);
    }
}
