package bigbigbai._00_assignment._00_array.lc3;

public class _643_MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        int res = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i-k];
            res = Math.max(res, sum);
        }

        return ((double) res) / k;
    }
}
