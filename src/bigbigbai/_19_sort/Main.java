package bigbigbai._19_sort;

import bigbigbai._19_sort.utils.Asserts;
import bigbigbai._19_sort.utils.Integers;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] randomArray = Integers.random(100, 1, 200);
        System.out.println(Arrays.toString(randomArray));

//        Sort<Integer> sort = new _01_BubbleSort3<>();
//        sort.sort(randomArray);

        testSorts(randomArray,
                new _01_BubbleSort<>(),
                new _02_SelectionSort<>()
//                new _01_BubbleSort3<>()

        );

        System.out.println(Arrays.toString(randomArray));
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
