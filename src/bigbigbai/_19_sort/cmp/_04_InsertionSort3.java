package bigbigbai._19_sort.cmp;

import bigbigbai._19_sort.Sort;

public class _04_InsertionSort3<T extends Comparable<T>> extends Sort<T> {
    public void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            T v = array[begin];

            int insertIndex = search(begin);
            for (int j = begin; j > insertIndex; j--) {
                array[j] = array[j - 1];
            }
            array[insertIndex] = v;
        }
    }

    /**
     *
     * @param index: Sorted array's right border ((, ])
     * @author: Dal
     */
    public int search(int index) {
        if (array == null || array.length == 0) return -1;

        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;

            if (cmp(array[index], array[mid]) < 0) end = mid;
            else begin = mid + 1;
        }

        return begin;
    }
}
