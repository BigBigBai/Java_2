package bigbigbai._14_divide_and_conquer;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/maximum-subarray/description/
 *
 */
public class _53_MaxSubArray {
    @Test
    public void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray3(nums));
    }

    public int maxSubArray3(int[] nums) {
        return maxSubArray3(nums, 0, nums.length);
    }

    private int maxSubArray3(int[] nums, int start, int end) {
//        if (start == end) return nums[start];//[]
        if (end - start < 2) return nums[start];//[)

        int mid = (start + end) >> 1;

        int leftSum = 0;
        int leftMax = Integer.MIN_VALUE;
        for (int i = mid - 1; i >= start; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int rightSum = 0;
        int rightMax = Integer.MIN_VALUE;
        for (int i = mid; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }

        return Math.max(Math.max(maxSubArray3(nums, start, mid), maxSubArray3(nums, mid, end)), leftMax + rightMax);
    }




    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int start = 0; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += nums[i];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
