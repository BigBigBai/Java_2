package bigbigbai._00_assignment._00_array.lc3;

public class _566_ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) return mat;

        int[][] res = new int[r][c];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (index2 < c) {
                    res[index1][index2++] = mat[i][j];
                } else {
                    index1++;
                    index2 = 0;
                    res[index1][index2++] = mat[i][j];
                }
            }
        }

        return res;
    }
}
