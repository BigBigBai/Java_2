package bigbigbai._00_assignment._00_array.lc2;

public class _463_IslandPerimeter2 {
    int[][] matrix;
    int m, n;

    public int islandPerimeter(int[][] grid) {
        matrix = grid;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    return dfs1(i, j);
                }
            }
        }
        return 0;
    }

    private int dfs1(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] == 0) return 1;
        if (matrix[i][j] == 2) return 0;

        matrix[i][j] = 2;
        return dfs1(i - 1, j) + dfs1(i + 1, j) + dfs1(i, j - 1) + dfs1(i, j + 1);
    }

}
