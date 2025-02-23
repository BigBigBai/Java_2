package bigbigbai._16_dp._01_dp;

public class PuzzleSum {
    public static void main(String[] args) {
        int[][] matrix = {{3,1,0,2},{4,3,2,1},{5,2,1,0}};
        System.out.println(sum2(matrix));
    }

    /**
     * DP
     * Calculate start from (0,0), to the right-bottom point's min path-sum
     * Calculate start from (0,0), to the (i,j)'s min path-sum
     */
    public static int sum2(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) dp[i][j] = matrix[i][j];
                else if (i == 0) dp[i][j] = matrix[i][j] + dp[i][j - 1];
                else if (j == 0) dp[i][j] = matrix[i][j] + dp[i -  1][j];
                else dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[rows - 1][cols - 1];
    }

    /**
     * Recursion
     * Calculate start from (0,0), to the right-bottom point's min path-sum
     * Calculate start from (i,j), to the right-bottom point's min path-sum
     */
    public static int sum(int[][] matrix) {
        return sum(matrix, 0, 0);
    }

    private static int sum(int[][] matrix, int i, int j) {

        if (i == matrix.length - 1 && j == matrix[0].length - 1) return matrix[i][j];
        // last row
        if (i == matrix.length - 1) return matrix[i][j] + sum(matrix, i, j + 1);
        // last col
        if (j == matrix[0].length - 1) return matrix[i][j] + sum(matrix, i + 1, j);

        return matrix[i][j] + Math.min(sum(matrix, i + 1, j), sum(matrix, i, j + 1));
    }
}
