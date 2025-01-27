package bigbigbai._00_assignment._0120;

public class Problem1 {
    public static void main(String[] args) {
        int[] array = {2,1,3,5,4};
        System.out.println(solution2(array));// 3

        int[] array1 = {2,3,4,1,5};
        System.out.println(solution2(array1));// 2

        int[] array2 = {1,3,4,2,5};
        System.out.println(solution2(array2));// 3

    }

    /**
     *
     * @author: online
     */
    // O(n)
    public static int solution2(int[] array) {
        int res = 0;
        int maxIndex = 0;

        for (int i = 0; i < array.length; i++) {
            // which maxIndex bulb turns on
            maxIndex = Math.max(maxIndex, array[i]);
            // i + 1: how many bulbs turn on now
            if (maxIndex == i + 1) res++;
        }

        return res;
    }

    // O(n2)
    public static int solution(int[] array) {
        int res = 0;
        int length = array.length;
        boolean[] open = new boolean[length];

        for (int i = 0; i < length; i++) {
            open[array[i] - 1] = true;

            boolean allShines = true;
            for (int j = 0; j <= array[i] - 1; j++) {
                if (!open[j]) {
                    allShines = false;
                    break;
                }
            }
            if (allShines) res++;
        }

        return res;
    }
}
