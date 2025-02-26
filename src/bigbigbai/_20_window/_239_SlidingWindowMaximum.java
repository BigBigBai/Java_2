package bigbigbai._20_window;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Monotonic Queue
 */
public class _239_SlidingWindowMaximum {
    /**
     * res length: nums.length - k + 1
     * w: window left index
     * i: window right index
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        // w是res的index
        int w = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) { // Monotonic decreasing
                    deque.removeLast();
            }
            deque.offer(i);

            if (i >= k - 1) { // 合法窗口形成
                if (deque.peekFirst() < w) { // if就行
                    deque.removeFirst();
                }
                res[w++] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}
