package bigbigbai._00_assignment._00_array.lc3;

public class _674_LongestContinuousIncreasingSubsequence {
    // 滑动窗口
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        int left = 0;
        for (int right = 1; right < nums.length; right++) {

            // 符合条件
            if (nums[right] > nums[right - 1]) {
                res = Math.max(res, right - left + 1);
            }

            // 不符合条件
            if (nums[right] <= nums[right - 1]) {
                left = right;
            }

        }

        return res;
    }
}
