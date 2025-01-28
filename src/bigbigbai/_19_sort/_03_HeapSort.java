package bigbigbai._19_sort;

public class _03_HeapSort<T extends Comparable<T>> extends Sort<T> {
    private int size;

    /**
     * @author: Dal
     */
    public void sort() {
        // 1.heapify
        size = array.length;
        for (int i = size/2 - 1; i >= 0; i--) {
            siftDown(i);
        }

        // 2.Repeat the following operations
        // until there is only 1 element in the heap:
        // Swap the top and tail elements of the heap
        // Decrease the number of elements in the heap by 1
        // Then do siftDown operation on the 0 position
        while (size > 1) {
            swap(0, --size);
            siftDown(0);
        }
    }

    private void siftDown(int index) {
        T element = array[index];
        int half = size / 2;

        while (index < half) {
            // Two cases:
            // 1.only left
            // 2.left and right
            // 3.default: compare with left child
            int childIndex = 2 * index + 1;
            T child = array[childIndex];
            int rightIndex = childIndex + 1;

            // select a greater value from left and right
            if (rightIndex < size && cmp(array[rightIndex], child) > 0) {
                child = array[childIndex  = rightIndex];
            }

            // use left/right child's greater value and cmp with parent's value
            if (cmp(element, child) >= 0) break;
            array[index] = child;
            index = childIndex;
        }

        // only need to put it once
        array[index] = element;
    }
}
