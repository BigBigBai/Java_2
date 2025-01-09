package bigbigbai._00_assignment._02_stack.lc1;

import java.util.HashMap;
import java.util.Stack;

public class _496_NextGreaterElement1 {
    // 单调栈（递减）
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
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