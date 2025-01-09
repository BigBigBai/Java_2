package bigbigbai._00_leetcode._03_queue;

import java.util.Deque;
import java.util.LinkedList;

public class _239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        // w是res的index
        int w = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.removeLast();
            }
            deque.offer(i);

            if (i >= k - 1) { // 合法窗口形成
                while (deque.peekFirst() < w) { // if就行
                    deque.removeFirst();
                }
                res[w++] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}
