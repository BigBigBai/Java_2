package bigbigbai._15_greedy._02_greedy2;

import java.util.PriorityQueue;

/**
 * 假设一共有n个数
 * 需要做2个heap minHeap maxHeap
 * minHeap堆顶最终存的是较大的n/2个数中的最小值
 * maxHeap堆顶最终存的是较小的n/2个数中的最大值
 * 1.如果是n is odd
 * median 在n/2 + 1那个堆的堆顶
 * 2.如果是n is even
 * median是2个堆的堆顶元素的平均数
 */
public class MedianFinder {
    // 小顶堆：存储较大的 n/2 个数
    private PriorityQueue<Integer> minHeap;
    // 大顶堆：存储较小的 n/2 个数
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>(); // 默认小顶堆
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // 大顶堆
    }

    // 插入一个新数
    public void addNumber(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // 平衡两个堆的大小
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // 获取当前中位数
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek(); // 奇数时，中位数是 maxHeap 堆顶
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0; // 偶数时，中位数是两个堆顶的平均值
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        int[] data = {42, 17, 73, 5, 88, 36};

        for (int num : data) {
            System.out.println("add number: " + num);
            medianFinder.addNumber(num);
            System.out.println("current median: " + medianFinder.findMedian());
        }
    }
}
