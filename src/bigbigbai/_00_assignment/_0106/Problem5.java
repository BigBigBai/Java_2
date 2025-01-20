package bigbigbai._00_assignment._0106;

import java.util.Arrays;

public class Problem5 {
    // cannot think of the solution
    // will continue to work on it in week 01/20-01/26
    public static void main(String[] args) {
        String[][] matrix = {{"8", "9", "10"}, {"16", "X", "20"}, {"24", "X", "30"}};
        System.out.println(Arrays.deepToString(solution(matrix)));
    }

    public static String[][] solution(String[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        String[][] res = new String[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

            }
        }

        return res;
    }
}
