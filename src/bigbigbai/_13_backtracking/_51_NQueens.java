package bigbigbai._13_backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _51_NQueens {
    @Test
    public void test() {
        System.out.println(solveNQueens(4));
    }

    int[] cols; // cols[4] = 5; represents to put a queen in row 5, col 6
    int ways;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        cols = new int[n];
        place(0, res);
        return res;
    }

    private void place(int row, List<List<String>> res) {
        if (row == cols.length) {
            ways++;
            showQueen(res);
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                cols[row] = col;
                place(row + 1, res);
            }
        }
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            // col
            if (cols[i] == col) return false;
            // diagonal
            if (Math.abs(col - cols[i]) == row - i) return false;
        }
        return true;
    }

    private void showQueen(List<List<String>> res) {
        List<String> list = new ArrayList<>();
        for (int row = 0; row < cols.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) sb.append("Q");
                else sb.append(".");
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}
