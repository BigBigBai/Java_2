package bigbigbai._08_heap;

import bigbigbai._08_heap.printer.BinaryTrees;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

    }

    public static void topK1(Integer[] data, int k) {
        // 默认是小根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < data.length; i++) {
            if (minHeap.size() < k) {
                minHeap.add(data[i]);
            } else if (data[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(data[i]);
            }
        }

        Iterator<Integer> iterator = minHeap.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void topK(Integer[] data, int k) {
        BinaryHeap<Integer> heap = new BinaryHeap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // 改
            }
        });

        for (int i = 0; i < data.length; i++) {
            if (heap.size() < k) {
                heap.add(data[i]);
            } else {
                if (data[i] > heap.get()) heap.replace(data[i]); // 改
            }
        }

        BinaryTrees.println(heap);
    }

    @Test
    public void test2() {
        Integer[] arr = {70, 30, 34, 73, 60, 68, 43, 25, 72, 78, 90, 57};
        topK1(arr, 4);
    }

    @Test
    public void test1() {
        Integer[] arr = {70, 30, 34, 73, 60, 68, 43, 25, 72, 78, 90, 57};
        BinaryHeap<Integer> heap = new BinaryHeap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }, arr);

        BinaryTrees.println(heap);
        System.out.println("========================================");
    }

    @Test
    public void test() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(70);
        heap.add(30);
        heap.add(34);
        heap.add(73);
        heap.add(60);
        heap.add(68);
        heap.add(43);

        BinaryTrees.println(heap);
        System.out.println("========================================");

        while (heap.size() > 1) {
            heap.remove();
            BinaryTrees.println(heap);
            System.out.println("========================================");
        }
    }
}
