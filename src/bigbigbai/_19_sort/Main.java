package bigbigbai._19_sort;

import bigbigbai._19_sort.cmp.*;
import bigbigbai._19_sort.utils.Asserts;
import bigbigbai._19_sort.utils.Integers;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] randomArray = Integers.random(1_00_000, 1, 20_000_000);
//        System.out.println(Arrays.toString(randomArray));

//        Sort<Integer> sort = new _06_QuickSort<>();
//        sort.sort(randomArray);

        testSorts(randomArray,
                new _01_BubbleSort3<>(),
                new _02_SelectionSort<>(),
                new _03_HeapSort<>(),
                new _04_InsertionSort3<>(),
                new _05_MergeSort<>(),
                new _06_QuickSort<>()
        );

//        System.out.println(Arrays.toString(randomArray));
    }

    public static void testSorts(Integer[] randomArray, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(randomArray);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }

        Arrays.sort(sorts);

        for (Sort sort : sorts) {
            System.out.println(sort);
        }

    }
}
