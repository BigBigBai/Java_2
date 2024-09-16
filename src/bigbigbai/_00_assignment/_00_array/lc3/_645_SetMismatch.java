package bigbigbai._00_assignment._00_array.lc3;

import java.util.HashSet;

/**
 *
 * lowBit = xor & (-xor)
 * lowBit：x和y的二进制表示中的最低不同位，可以用来区分x和y
 *
 * 得到lowBit之后，可以将2n个数字分成两组
 * 第一组：每个数字a都满足a & lowBit = 0
 * 第二组：每个数字b都满足b & lowBit = 1
 *
 */
public class _645_SetMismatch {
    // (牛B)
    // 位运算
    // tc: O(n)
    // sc: O(1)
    public int[] findErrorNums2(int[] nums) {
        int n = nums.length;

        int xor = 0;
        for (int num : nums) xor ^= num;
        for (int i = 1; i <= n; i++) xor ^= i;

        int lowBit = xor & (-xor);
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & lowBit) == 0) num1 ^= num;
            else num2 ^= num;
        }
        for (int i = 1; i <= n; i++) {
            if ((i & lowBit) == 0) num1 ^= i;
            else num2 ^= i;
        }

        for (int num : nums) {
            if (num == num1) return new int[]{num1, num2};
        }
        return new int[]{num2, num1};
    }

    // 哈希表
    // tc: O(n)
    // sc: O(n)
    public int[] findErrorNums1(int[] nums) {
        int[] res = new int[2];

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) res[0] = num;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                res[1] = i;
                break;
            }
        }

        return res;
    }

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                res[0] = num;
                break;
            }
        }

        res[1] = res[0];
        for (int num : nums) res[1] ^= num;
        for (int i = 1; i <= nums.length; i++) res[1] ^= i;

        return res;
    }

    public static void main(String[] args) {
        int num1 = -1;
        System.out.println(Integer.toBinaryString(num1));

        int num2 = 3;
        System.out.println(Integer.toBinaryString(num2));
    }
}
