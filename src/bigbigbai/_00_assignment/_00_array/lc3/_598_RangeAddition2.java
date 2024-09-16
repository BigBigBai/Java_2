package bigbigbai._00_assignment._00_array.lc3;

import java.util.Arrays;
import java.util.HashMap;

public class _598_RangeAddition2 {
    public int maxCount(int m, int n, int[][] ops) {
        int[] res = {m, n};
        for (int[] op : ops) {
            res = overlap(res, op);
        }
        return res[0] * res[1];
    }

    public int[] overlap(int[] nums1, int[] nums2) {
        int[] res = new int[2];
        res[0] = Math.min(nums1[0], nums2[0]);
        res[1] = Math.min(nums1[1], nums2[1]);
        return res;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 1};
        HashMap<Integer[], Integer> map = new HashMap<>();
        map.put(arr, 10);
        System.out.println(Arrays.toString(arr));
        System.out.println(map.get(arr));

        arr[0] = 10;
        arr[1] = 20;
        System.out.println(Arrays.toString(arr));
        System.out.println(map.get(arr));
    }
}
