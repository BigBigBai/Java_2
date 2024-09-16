package bigbigbai._00_assignment._00_array.lc1;

/**
 * 要求
 * tc：O(n)
 * sc: O(1)
 *（牛B）异或运算
 * 1.任何数和0做异或运算，结果仍然是原来的数，即a ^ 0 = a
 * 2.任何数和其自身做异或运算，结果是0，即a ^ a = 0
 * 3.异或运算满足交换律和结合律，即a^b^a = b^a^a = b^(a^a) = b^0 = b
 */
public class _136_SingleNumber {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
