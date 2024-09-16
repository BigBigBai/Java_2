package bigbigbai._00_assignment._00_array.lc1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 要求
 * tc：O(n)
 * sc: O(1)
 */
public class _169_MajorityElement {
    // 方法3: Boyer-Moore投票算法
    // tc: O(n)
    // sc: O(1)
    public int majorityElement2(int[] nums) {
        Integer res = null;
        int count = 0;

        for (int num : nums) {
            if (count == 0) res = num;
            if (num == res) count++;
            else count--;
        }

        return res;
    }

    // 方法2: 排序
    // tc：O(n logn)
    // sc: O(logn)/O(1)
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    // 方法1: 哈希表
    // tc：O(n)
    // sc: O(n)
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }

        Map.Entry<Integer, Integer> res = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (nums.length >> 1)) {
                res = entry;
            }
        }
        return res.getKey();
    }
}
