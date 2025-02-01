package bigbigbai._19_sort.cmp;

import bigbigbai._19_sort.Sort;

public class _05_MergeSort<T extends Comparable<T>> extends Sort<T> {
    private T[] leftArray;

    @Override
    protected void sort() {
        leftArray = (T[]) new Comparable[array.length >> 1];

        sort(0, array.length);
    }

    protected void sort(int begin, int end) {
        if (end - begin <= 1) return;

        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    private void merge(int begin, int mid, int end) {
        int li = 0;
        int le = mid - begin;
        int ri = mid;
        int re = end;
        int ai = begin;
        // 1. backup the left array
        for (int i = li; i < le; i++) {
            leftArray[i] = array[begin + i];
        }

        // 2. merge left and right
        while (li < le) {
            if (ri < re && cmp(array[ri], leftArray[li]) < 0) {
                array[ai++] = array[ri++];
            } else {
                array[ai++] = leftArray[li++];
            }
        }

    }
}
