package bigbigbai._16_dp._01_dp3;

/**
 * https://leetcode.cn/problems/longest-common-subsequence/description/
 */
public class LCS {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,7};
        int[] nums2 = {1,3,5,7};

        System.out.println(lcs5(nums1, nums2));
    }

    /**
     * DP
     * String
     */
    public static int lcs6(String text1, String text2) {
        char[] nums1 = text1.toCharArray();
        char[] nums2 = text2.toCharArray();

        char[] rowsNums = nums1, colsNums = nums2;
        if (nums1.length < nums2.length) {
            colsNums = nums1;
            rowsNums = nums2;
        }

        int[] dp = new int[colsNums.length + 1];
        for (int i = 1; i <= rowsNums.length; i++) {
            int cur = 0;
            for (int j = 1; j <= colsNums.length; j++) {
                int leftTop = cur;

                cur = dp[j];
                if (rowsNums[i-1] == colsNums[j-1]) dp[j] = leftTop + 1;
                else dp[j] = Math.max(dp[j-1], dp[j]);
            }
        }
        return dp[colsNums.length];
    }

    /**
     * DP
     * sc: O(min{m, n})
     */
    public static int lcs5(int[] nums1, int[] nums2) {
        int[] rowsNums = nums1, colsNums = nums2;
        if (nums1.length < nums2.length) {
            colsNums = nums1;
            rowsNums = nums2;
        }

        int[] dp = new int[colsNums.length + 1];
        for (int i = 1; i <= rowsNums.length; i++) {
            int cur = 0;
            for (int j = 1; j <= colsNums.length; j++) {
                int leftTop = cur;

                cur = dp[j];
                if (rowsNums[i-1] == colsNums[j-1]) dp[j] = leftTop + 1;
                else dp[j] = Math.max(dp[j-1], dp[j]);
            }
        }
        return dp[colsNums.length];
    }

    /**
     * DP
     * sc: O(n)
     */
    public static int lcs4(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            int cur = 0;
            for (int j = 1; j <= nums2.length; j++) {
                int leftTop = cur;

                cur = dp[j];
                if (nums1[i-1] == nums2[j-1]) dp[j] = leftTop + 1;
                else dp[j] = Math.max(dp[j-1], dp[j]);
            }
        }
        return dp[nums2.length];
    }

    /**
     * DP
     * sc: O(2*n)
     * % 2 == & 1
     */
    public static int lcs3(int[] nums1, int[] nums2) {
        int[][] dp = new int[2][nums2.length+1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                int row = i & 1;
                int preRow = (i - 1) & 1;

                if (nums1[i-1] == nums2[j-1]) dp[row][j] = dp[preRow][j-1] + 1;
                else dp[row][j] = Math.max(dp[row][j-1], dp[preRow][j]);
            }
        }
        return dp[nums1.length & 1][nums2.length];
    }

    /**
     * DP
     * sc: O(2*n)
     */
    public static int lcs2(int[] nums1, int[] nums2) {
        int[][] dp = new int[2][nums2.length+1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                int row = i % 2;
                int preRow = (i - 1) % 2;

                if (nums1[i-1] == nums2[j-1]) dp[row][j] = dp[preRow][j-1] + 1;
                else dp[row][j] = Math.max(dp[row][j-1], dp[preRow][j]);
            }
        }
        return dp[nums1.length %  2][nums2.length];
    }

    /**
     * DP
     * tc: O(m*n)
     * sc: O(m*n)
     */
    public static int lcs1(int[] nums1, int[] nums2) {
        int[][]dp = new int[nums1.length+1][nums2.length+1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i-1] == nums2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        return dp[nums1.length][nums2.length];
    }

    /**
     * recursion
     * tc: O(2^n), n = m
     * sc: min{m, n}
     */
    public static int lcs(int[] nums1, int[] nums2) {
        return lcs(nums1, nums1.length, nums2, nums2.length);
    }

    private static int lcs(int[] nums1, int i, int[] nums2, int j) {
        if (i == 0 || j == 0) return 0;

        if (nums1[i-1] == nums2[j-1]) return lcs(nums1, i-1, nums2, j-1) + 1;
        return Math.max(lcs(nums1, i-1, nums2, j), lcs(nums1, i, nums2, j-1));
    }
}
