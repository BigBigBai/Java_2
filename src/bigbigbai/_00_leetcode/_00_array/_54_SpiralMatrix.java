package bigbigbai._00_leetcode._00_array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/spiral-matrix/submissions/440792168/
 *
 */
public class _54_SpiralMatrix {
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (left <= right && top <= bottom) {
            //left top ---> right top
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            //right top ---> right bottom
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (top > bottom) break;
            if (left > right) break;

            //right bottom ---> left bottom
            for (int i = right; i >= left ; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;

            //left bottom ---> left top
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }


        return list;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = 0;

        boolean[][] visited = new boolean[rows][cols];


        while (list.size() < rows * cols) {
            if (i > -1 && i < rows && j > -1 && j < cols && !visited[i][j]) {
                list.add(matrix[i][j]);
                visited[i][j] = true;
            } else {
                i = i - directions[d][0];
                j = j - directions[d][1];
                d = (d + 1) % 4;
            }

            i = i + directions[d][0];
            j = j + directions[d][1];
        }

        return list;
    }
}
