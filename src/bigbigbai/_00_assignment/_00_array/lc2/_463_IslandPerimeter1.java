package bigbigbai._00_assignment._00_array.lc2;

public class _463_IslandPerimeter1 {
    int res = 0;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    int[][] matrix;
    int m, n;

    public int islandPerimeter(int[][] grid) {
        matrix = grid;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 2;
                    dfs(i, j);
                    return res;
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int ni = i + dirs[k][0];
            int nj = j + dirs[k][1];
            if (ni < 0 || ni >= m || nj < 0 || nj >= n || matrix[ni][nj] == 0) res++;
            else {
                if (matrix[ni][nj] == 1) {
                    matrix[ni][nj] = 2;
                    dfs(ni, nj);
                }
            }
        }
    }

}
