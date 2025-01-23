package bigbigbai._18_palindrome;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * @author dal
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    // dp
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return null;

        char[] cs = s.toCharArray();

        boolean[][] dp = new boolean[cs.length][cs.length];
        int begin = 0;
        int maxLen = 1;
        for (int i = cs.length - 1; i >= 0; i--) {
            for (int j = i; j < cs.length; j++) {
                int len = j - i + 1;

                // dp
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
