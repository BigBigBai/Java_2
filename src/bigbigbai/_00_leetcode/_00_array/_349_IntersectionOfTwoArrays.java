package bigbigbai._00_leetcode._00_array;

import java.util.HashSet;
import java.util.Set;

public class _349_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int ele : nums1) {
            set1.add(ele);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int ele : nums2) {
            set2.add(ele);
        }

        Set<Integer> res = new HashSet<>();
        for (Integer ele: set1) {
            if (set2.contains(ele))
                res.add(ele);
        }

        int[] arr = new int[res.size()];
        int i = 0;
        for (Integer ele: res) {
            arr[i++] = ele;
        }
        return arr;
    }
}
