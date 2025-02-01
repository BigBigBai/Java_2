package bigbigbai._19_sort.cmp;

import bigbigbai._19_sort.Sort;

public class _01_BubbleSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            for (int start = 1; start <= end; start++) {
                if (cmp(array[start], array[start - 1]) < 0) {
                    swap(start, start - 1);
                }
            }
        }
    }
}
