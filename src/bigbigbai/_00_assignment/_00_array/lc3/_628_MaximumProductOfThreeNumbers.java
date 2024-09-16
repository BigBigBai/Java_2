package bigbigbai._00_assignment._00_array.lc3;

import java.util.Arrays;

public class _628_MaximumProductOfThreeNumbers {
    // 线性扫描
    // 求出最大三个数，最小两个数
    // [min1, min2, ... max3, max2, max1]
    public int maximumProduct1(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }

        return Math.max(min1 * min2 * max1, max3 * max2 * max1);
    }

    // 排序
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // 负负正
        int num1 = nums[0] * nums[1] * nums[n-1];

        // 正正正
        int num2 = nums[n-3] * nums[n-2] * nums[n-1];

        return Math.max(num1, num2);
    }
}
