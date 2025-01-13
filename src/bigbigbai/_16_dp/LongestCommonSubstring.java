package bigbigbai._16_dp;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "ABCBA";
        String s2 = "BABCA";
        System.out.println(longestCommonSubstring(s1, s2));
    }

    public static int longestCommonSubstring1(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        int[][] dp = new int[ch1.length + 1][ch2.length + 1];
        int max = 0;
        for (int i = 1; i <= ch1.length; i++) {
            for (int j = 1; j <= ch2.length; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max;
    }

    public static int longestCommonSubstring(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        int[][] dp = new int[ch1.length + 1][ch2.length + 1];
        int max = 0;
        for (int i = 1; i <= ch1.length; i++) {
            for (int j = 1; j <= ch2.length; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max;
    }
}
