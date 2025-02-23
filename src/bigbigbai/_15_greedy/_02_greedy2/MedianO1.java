package bigbigbai._15_greedy._02_greedy2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianO1 {
    public static void main(String[] args) {
        System.out.println(findMedian(new Integer[]{42,17,73,5,88,36}));
    }

    public static double findMedian(Integer[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int n = nums.length;
        int k = n >> 1;
        int tmp = n & 1;
        for (int i = 0; i < n; i++) {// Top K
            if (minHeap.size() < k + tmp) {
                minHeap.offer(nums[i]);
            } else if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        for (int i = 0; i < n; i++) {// Min K
            if (maxHeap.size() < k) {
                maxHeap.offer(nums[i]);
            } else if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        }

        if (tmp == 1) return minHeap.peek();
        else return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}
