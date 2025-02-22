package bigbigbai._13_backtracking;

import org.junit.Test;

public class _52_NQueens {
    @Test
    public void test() {
        System.out.println(totalNQueens(4));
    }

    int[] cols; // cols[4] = 5; represents to put a queen in row 5, col 6
    int ways;

    public int totalNQueens(int n) {
        cols = new int[n];
        place(0);
        return ways;
    }

    private void place(int row) {
        if (row == cols.length) {
            ways++;
            showQueen();
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                cols[row] = col;
                place(row + 1);
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

    private void showQueen() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) System.out.print("Q");
                else System.out.print(".");
            }
            System.out.println();
        }
        System.out.println();
    }
}
