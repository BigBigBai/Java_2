package bigbigbai._00_assignment._00_array.lc2;

import java.util.HashMap;
import java.util.Stack;

/**
 * (牛B)
 * 单调栈：递减
 *
 * 哈希表：
 * key: 当前值
 * value: 当前值的next greater element
 */
public class _496_NextGreaterElement1 {
    // 单调栈(递减) + 哈希表
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {// 维护单调递减
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] res = new int[nums1.length];
        int index = 0;
        for (int num : nums1) {
            res[index++] = map.getOrDefault(num, -1);
        }
        return res;
    }
}
