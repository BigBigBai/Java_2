package bigbigbai._19_sort;

public class _06_QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort() {
        sort(0, array.length);
    }

    private void sort(int begin, int end) {
        if (end - begin <= 1) return;

        int pivot = pivotIndex(begin, end);
        sort(begin, pivot);
        sort(pivot + 1, end);

    }

    /**
     * 1. find pivotIndex
     * 2. put value <= pivot to the left of pivot, put value > pivot to the right of pivot
     * @param begin
     * @param end
     * @return
     */
    private int pivotIndex(int begin, int end) {
        // 0. randomly select an element as pivot, swap with begin element
        swap(begin, begin + (int) (Math.random() * (end-begin)));

        // 1. backup start point
        T pivot = array[begin];
        end--;

        while (begin < end) {
            // 2.1 end from right to left
            while (begin < end) {
                if (cmp(pivot, array[end]) < 0) end--;
                else {
                    array[begin++] = array[end];
                    break;
                }
            }

            // 2.2 begin from left to right
            while (begin < end) {
                if (cmp(pivot, array[begin]) >= 0) begin++;
                else {
                    array[end--] = array[begin];
                    break;
                }
            }
        }

        // 3. put backup into pivotIndex position
        array[begin] = pivot;

        return begin;
    }
}
