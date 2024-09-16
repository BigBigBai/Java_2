package bigbigbai._00_assignment._00_array.lc2;

/**
 *  位运算
 *  x ^ x = 0
 *  x ^ 0 = x
 */
public class _268_MissingNumber {
    // tc: O(n)
    // sc: O(1)
    public int missingNumber(int[] nums) {
        int res = 0;

        for (int num : nums)
            res ^= num;


        for (int i = 0; i <= nums.length; i++)
            res ^= i;

        return res;
    }
}
