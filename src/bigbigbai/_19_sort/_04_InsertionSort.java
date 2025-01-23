package bigbigbai._19_sort;

public class _04_InsertionSort<T extends Comparable<T>> extends Sort<T> {
    public void sort2() {
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
     * @param index: Ordered array's right border ((, ])
     * @return
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

    public void sort1() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            T v = array[cur];
            while (cur > 0 && cmp(v, array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = v;
        }
    }

    public void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, cur - 1);
                cur--;
            }
        }
    }
}
