package bigbigbai._00_amazon._01_array._0303_;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/jump-game-viii/description/?envType=company&envId=amazon&favoriteSlug=amazon-thirty-days
 * @author: LC
 */
public class _2297_JumpGameVIII {
    public long minCost(int[] nums, int[] costs) {
        long[] dp = new long[nums.length];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        Stack<Integer> minStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();

        for (int j = 0; j < nums.length; j++) {
            while (!minStack.isEmpty() && nums[minStack.peek()] <= nums[j]) {
                int i = minStack.pop();// nums[j]是i之后第一个大于等于nums[i]的数字
                dp[j] = Math.min(dp[j], dp[i] + costs[j]);
            }
            minStack.push(j);


            while (!maxStack.isEmpty() && nums[maxStack.peek()] > nums[j]) {
                int i = maxStack.pop();// nums[j]是i之后第一个比nums[i]小的数字
                dp[j] = Math.min(dp[j], dp[i] + costs[j]);
            }
            maxStack.push(j);
        }

        return dp[nums.length - 1];
    }
}
