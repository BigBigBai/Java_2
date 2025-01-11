package bigbigbai._16_dp;

/**
 * https://leetcode.cn/problems/longest-common-subsequence/description/
 */
public class LCS {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,7};
        int[] nums2 = {1,3,5,7};

        System.out.println(lcs(nums1, nums2));
    }

    public static int lcs(int[] nums1, int[] nums2) {
        return lcs(nums1, nums1.length, nums2, nums2.length);
    }

    private static int lcs(int[] nums1, int i, int[] nums2, int j) {
        if (i == 0 || j == 0) return 0;

        if (nums1[i-1] == nums2[j-1]) return lcs(nums1, i-1, nums2, j-1) + 1;

        return Math.max(lcs(nums1, i-1, nums2, j), lcs(nums1, i, nums2, j-1));
    }
}
