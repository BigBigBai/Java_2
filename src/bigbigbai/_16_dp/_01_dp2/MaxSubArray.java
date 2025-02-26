package bigbigbai._16_dp._01_dp2;

/**
 * https://leetcode.cn/problems/maximum-subarray/description/
 */
public class MaxSubArray {
    public static void main(String[] args) {

    }

    public int maxSubArray2(int[] nums) {
        // 1. Define state
        // 2. Set initial state
        int dp = nums[0];
        int max = dp;
        // 3. Determine the state transition equation
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(nums[i], dp + nums[i]);
            max = Math.max(max, dp);
        }

        return max;
    }

    /**
     * dp(i): the sum of its maximum contiguous subarray ending in nums[i]
     *
     */
    public int maxSubArray(int[] nums) {
        // 1. Define state
        int[] dp = new int[nums.length];

        // 2. Set initial state
        dp[0] = nums[0];
        int max = dp[0];
        // 3. Determine the state transition equation
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
