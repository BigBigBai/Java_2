package bigbigbai._18_palindrome;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * @author Dal
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    /**
     * DP
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return null;
        char[] cs = s.toCharArray();

        boolean[][] dp = new boolean[cs.length][cs.length];
        int maxLen = 1;
        int begin = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            for (int j = i; j < cs.length; j++) {
                int len = j - i + 1;

                if (len <= 2) {
                    dp[i][j] = cs[i] == cs[j];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && cs[i] == cs[j];
                }

                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    begin = i;
                }
            }
        }

        return new String(cs, begin, maxLen);
    }
}
