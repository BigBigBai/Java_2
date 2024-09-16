package bigbigbai._00_assignment._00_array.lc2;

public class _463_IslandPerimeter {
    int res = 0;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    int[][] matrix;
    int m, n;
    boolean[][] visited;

    public int islandPerimeter(int[][] grid) {
        int i1 = 0;
        int j1 = 0;

        matrix = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
                if (matrix[i][j] == 1) {
                    i1 = i;
                    j1 = j;
                }
            }
        }

        visited[i1][j1] = true;
        dfs(i1, j1);
        return res;
    }

    private void dfs(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int ni = i + dirs[k][0];
            int nj = j + dirs[k][1];
            if (ni < 0 || ni >= m || nj < 0 || nj >= n) res++;
            else {
                if (matrix[ni][nj] == 0) res++;
                else {
                    if (!visited[ni][nj]) {
                        visited[ni][nj] = true;
                        dfs(ni, nj);
                    }
                }
            }
        }
    }

}
