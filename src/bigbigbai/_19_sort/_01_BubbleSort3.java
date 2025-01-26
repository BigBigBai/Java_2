package bigbigbai._19_sort;

public class _01_BubbleSort3<T extends Comparable<T>> extends Sort<T> {

    public void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int sortedIndex = 1;
            for (int start = 1; start <= end; start++) {
                if (cmp(array[start], array[start - 1]) < 0) {
                    swap(start, start - 1);
                    sortedIndex = start;
                }
            }
            end = sortedIndex;
        }
    }

}
