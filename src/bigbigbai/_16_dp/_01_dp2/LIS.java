package bigbigbai._16_dp._01_dp2;

public class LIS {
    public int lengthOfLIS(int[] nums) {
        // 1. Define state
        int[] dp = new int[nums.length];
        // 2. Set initial state
        dp[0] = 1;
        int max = 1;
        // 3. Determine the state transition equation
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
