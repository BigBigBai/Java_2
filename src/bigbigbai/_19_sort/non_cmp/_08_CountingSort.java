package bigbigbai._19_sort.non_cmp;

import java.util.Arrays;

public class _08_CountingSort {
    public static void main(String[] args) {
        Integer[] arr = {7,3,5,8,6,7,4,5};
        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort2(Integer[] arr) {
        // 1. find max value in original array
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
            if (min > arr[i]) min = arr[i];
        }

        // 2. create counts array to count the times of each element in org array
        int[] counts = new int[max + 1];
        for (int i = 0; i < arr.length; i++) counts[arr[i]-min]++;

        // 2.1 aggregate each value's appearance
        for (int i = 1; i < counts.length; i++) counts[i] += counts[i-1];

        // 3. from right to left, put counts array's each element to new array
        int[] res = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            //
            res[--counts[arr[i]-min]] = arr[i];
        }

        // 4. put res data back to arr
        for (int i = 0; i < arr.length; i++) arr[i] = res[i];
    }

    public static void sort(Integer[] arr) {
        // 1.find max value in original array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }

        // 2.create counts array to count the times of each element in org array
        int[] counts = new int[max + 1];
        for (int i = 0; i < arr.length; i++) counts[arr[i]]++;

        // 3.use counts array's non-zero value index to sort org array
        int index = 0;
        for (int i = 1; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                arr[index++] = i;
            }
        }

    }
}
