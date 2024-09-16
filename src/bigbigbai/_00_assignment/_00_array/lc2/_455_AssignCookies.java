package bigbigbai._00_assignment._00_array.lc2;

import java.util.Arrays;

public class _455_AssignCookies {
    // 排序 + 双指针
    // tc: O(mlogm + nlogn)
    // sc: O(logm + logn) -> 排序的额外空间开销
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index1 = 0, index2 = 0;
        while (index1 < g.length && index2 < s.length) {
            if (g[index1] <= s[index2]) {
                index1++;
                index2++;
            } else {
                index2++;
            }
        }

        return index1;
    }
}
