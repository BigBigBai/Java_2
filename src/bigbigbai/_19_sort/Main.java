package bigbigbai._19_sort;

import bigbigbai._19_sort.utils.Asserts;
import bigbigbai._19_sort.utils.Integers;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] randomArray = Integers.random(100, 1, 200);
        Integers.println(randomArray);
//        System.out.println("===============================");
//        HeapSort<Integer> heapSort = new HeapSort<>();
//        heapSort.sort(randomArray);
        // Integers.println(randomArray);
        testSorts(randomArray,
                new _01_BubbleSort<>()
//                new _04_InsertionSort<>()


        );

        Integers.println(randomArray);
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
