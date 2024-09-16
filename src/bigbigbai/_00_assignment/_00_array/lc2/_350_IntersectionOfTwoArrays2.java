package bigbigbai._00_assignment._00_array.lc2;

import java.util.*;

public class _350_IntersectionOfTwoArrays2 {
    // 方法2: 排序 + 双指针
    // tc: O(mlogm + nlogn)
    // sc: O(min(m, n))
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0;

        int length = Math.min(nums1.length, nums2.length);
        int[] res = new int[length];
        int index = 0;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                res[index++] = nums1[index1];
                index1++;
                index2++;
            }
        }

        return Arrays.copyOfRange(res, 0, index);
    }

    // 方法1: 哈希表
    // tc: O(m + n)
    // sc: O(min(m, n))
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int j : nums1) {
            if (map1.containsKey(j)) map1.put(j, map1.get(j) + 1);
            else map1.put(j, 1);
        }

        int[] res = new int[nums1.length];
        int index = 0;
        for (int j : nums2) {
            if (map1.containsKey(j) && map1.get(j) > 0) {
                res[index++] = j;
                map1.put(j, map1.get(j) - 1);
            }
        }

        return Arrays.copyOfRange(res, 0, index);
    }
}
