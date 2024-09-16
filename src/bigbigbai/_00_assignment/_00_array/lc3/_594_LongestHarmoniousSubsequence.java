package bigbigbai._00_assignment._00_array.lc3;

import java.util.Arrays;
import java.util.HashMap;

public class _594_LongestHarmoniousSubsequence {
    // (牛B)
    // 排序 + 滑动窗口
    public int findLHS1(int[] nums) {
        int res = 0;
        Arrays.sort(nums);

        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            while (nums[right] - nums[left] > 1) {
                left++;
            }

            if (nums[right] - nums[left] == 1) {
                res = Math.max(res, right - left + 1);
            }
        }

        return res;
    }

    // 哈希表
    // tc：O(n)
    // sc: O(n)
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                res = Math.max(res, map.get(key) + map.get(key + 1));
            }
        }
        return res;
    }
}
