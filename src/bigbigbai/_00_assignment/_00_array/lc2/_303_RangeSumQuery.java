package bigbigbai._00_assignment._00_array.lc2;

public class _303_RangeSumQuery {
    // 前缀和
    static class NumArray {
        int[] sums;

        public NumArray(int[] nums) {
            int n = nums.length;
            sums = new int[n + 1];

            for (int i = 0; i < n; i++) {
                sums[i + 1]  = sums[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right + 1] - sums[left];
        }
    }
}
