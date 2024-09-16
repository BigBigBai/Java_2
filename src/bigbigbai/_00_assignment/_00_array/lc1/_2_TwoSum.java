package bigbigbai._00_assignment._00_array.lc1;

import java.util.Arrays;
import java.util.HashMap;

public class _2_TwoSum {
    // 错误代码，因为改变了数组的index位置
    public int[] twoSum1(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    // 哈希表
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};

            map.put(nums[i], i);
        }
        return null;
    }
}
