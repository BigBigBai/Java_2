package bigbigbai._19_sort.cmp;

import bigbigbai._19_sort.Sort;

public class _02_SelectionSort<T extends Comparable<T>> extends Sort<T> {
    public void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int start = 1; start <= end; start++) {
                if (array[maxIndex].compareTo(array[start]) < 0) {
                    maxIndex = start;
                }
            }

            swap(maxIndex, end);
        }
    }
}
