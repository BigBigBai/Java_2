package bigbigbai._00_assignment._00_array.lc2;

import java.util.Arrays;

public class _561_ArrayPartition {
    // 排序
    public int arrayPairSum(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            res += nums[i];
        }
        return res;
    }
}
