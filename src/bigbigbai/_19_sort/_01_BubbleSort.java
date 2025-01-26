package bigbigbai._19_sort;

import java.util.Arrays;

public class _01_BubbleSort<T extends Comparable<T>> extends Sort<T> {
    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        arr[0] = 99;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 2;
        arr[4] = 5;
        arr[5] = 6;
        arr[6] = 7;
        arr[7] = 10;
        arr[8] = 5;
        arr[9] = 1;
        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort2(Integer[] arr) {
        for (int end = arr.length - 1; end > 0; end--) {
            int sortedIndex = 1;
            for (int start = 1; start <= end; start++) {
                if (arr[start] < arr[start - 1]) {
                    int temp = arr[start];
                    arr[start] = arr[start - 1];
                    arr[start - 1] = temp;
                    sortedIndex = start;
                }
            }
            end = sortedIndex;
        }
    }

    public static void sort1(Integer[] arr) {
        for (int end = arr.length - 1; end > 0; end--) {
            boolean sorted = true;
            for (int start = 1; start <= end; start++) {
                if (arr[start] < arr[start - 1]) {
                    int temp = arr[start];
                    arr[start] = arr[start - 1];
                    arr[start - 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }

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
