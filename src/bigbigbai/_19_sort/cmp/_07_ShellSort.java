package bigbigbai._19_sort.cmp;

import bigbigbai._19_sort.Sort;

import java.util.ArrayList;
import java.util.List;

public class _07_ShellSort<T extends Comparable<T>> extends Sort<T> {

    public void sort() {
        List<Integer> sequence = shellSequence();

        for (Integer step: sequence) {
            sort(step);
        }
    }

    /**
     * divide into step column to do sorting
     * @param step
     */
    private void sort(int step) {
        for (int col = 0; col < step; col++) {
            for (int begin = col + step; begin < array.length; begin += step) {
                int cur = begin;
                while (cur > 0 && cmp(cur, cur - step) < 0) {
                    swap(cur, cur - step);
                    cur -= step;
                }
            }
        }
    }

    private List<Integer> shellSequence() {
        List<Integer> sequence = new ArrayList<>();

        int len = array.length;

        // Ex: len = 16, {8, 4, 2, 1}
        while ((len = len >> 1) > 0) {
            sequence.add(len);
        }

        return sequence;
    }

}
