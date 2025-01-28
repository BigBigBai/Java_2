package bigbigbai._19_sort;

public class _04_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,12,14};
//        System.out.println(indexOf(arr, 10));
        System.out.println(search(arr, 8));
    }

    // Find element intersect position in sorted array
    public static int search(int[] array, int value) {
        if (array == null || array.length == 0) return -1;

        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;

            if (array[mid] > value) end = mid;
            else begin = mid + 1;
        }

        return begin;
    }

    // Find element index in sorted array
    public static int indexOf(int[] array, int value) {
        if (array == null || array.length == 0) return -1;

        // [,)
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (array[mid] == value) return mid;
            else if (array[mid] > value) end = mid;
            else begin = mid + 1;
        }

        return -1;
    }
}

