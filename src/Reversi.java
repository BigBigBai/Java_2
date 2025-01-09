import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reversi {
    public static void main(String[] args) throws IOException {
        int m = 8, n = 8;
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
                if ((i == 3 && j == 3) || (i == 4 && j == 4)) board[i][j] = 'W';
                if ((i == 3 && j == 4) || (i == 4 && j == 3)) board[i][j] = 'B';
            }
        }
        printBoard(board);

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int count = 1;
        // 奇数为黑棋, 偶数为白棋
        while (true) {
            char color;
            char oppoColor;
            if (count % 2 == 1) {
                color = 'B';
                oppoColor = 'W';
            } else {
                color = 'W';
                oppoColor = 'B';
            }

            // 检测游戏是否结束 (双方无valid落点)
            // 检测有无valid落点
            int countBlack = 0;
            int countWhite = 0;
            boolean existValidMove = false;
            boolean existValidMoveForOppo = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == '.') {
                        if (checkLoc(i, j, dirs, m, n, board, oppoColor, color)) {
                            existValidMove = true;
                            break;
                        }

                        if (checkLoc(i, j, dirs, m, n, board, color, oppoColor)) {
                            existValidMoveForOppo = true;
                        }
                    }
                    else if (board[i][j] == 'B') countBlack++;
                    else countWhite++;
                }
            }

            if (!existValidMove && !existValidMoveForOppo) {
                System.out.println("Game over!");
                if (countBlack - countWhite == 0) {
                    System.out.println("Draw!");
                } else {
                    String winners = countBlack > countWhite ? "Black" : "White";
                    System.out.println(winners + " wins by " + Math.abs(countBlack - countWhite) + " points!");
                }
                break;
            } else if (!existValidMove) {
                System.out.println(color + " player has no valid move.");
                count++;
                continue;
            }


            System.out.println("Enter move for color " + color + " (RowCol): ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            int bi = str.charAt(0) - '0';
            int bj = str.charAt(1) - '0';

            // 检查输入值是否是数字
            // 检查输入值范围
            if (bi < 0 || bi >= m || bj < 0 || bj >= n) {
                System.out.println("Invalid move. Try again.");
                printBoard(board);
                continue;
            }

            // 检查落点
            // 落点无棋子
            // 落点8个角必须有对手棋子
            // 连续直线上的位置,必须已经有自己颜色的棋子
            if (board[bi][bj] == '.' && updateLoc(bi, bj, dirs, m, n, board, oppoColor, color)) {
                count++;
            } else {
                System.out.println("Invalid move. Try again.");
            }

            printBoard(board);
        }
    }

    public static boolean updateLoc(int bi, int bj, int[][] dirs, int m, int n, char[][] board, char oppoColor, char color) {
        boolean found = false;
        for (int[] dir : dirs) {
            int ni = bi + dir[0];
            int nj = bj + dir[1];

            if (ni >= 0 && ni < m && nj >= 0 && nj < n && board[ni][nj] == oppoColor) {
                if (update(ni, nj, dir, m, n, board, oppoColor, color)) {
                    found = true;
                    board[bi][bj] = color;
                }
            }
        }
        return found;
    }

    public static boolean update(int ni, int nj, int[] dir, int m, int n, char[][] board, char oppoColor, char color) {
        boolean flag = false;

        if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
            if (board[ni][nj] == color) return true;
            else if (board[ni][nj] == oppoColor) {
                flag = update(ni + dir[0], nj + dir[1], dir, m, n, board, oppoColor, color);
            }
            else return false;
        }
        else return false;

        if (flag) board[ni][nj] = color;
        return flag;
    }

    public static boolean checkLoc(int bi, int bj, int[][] dirs, int m, int n, char[][] board, char oppoColor, char color) {
        boolean found = false;
        for (int[] dir : dirs) {
            int ni = bi + dir[0];
            int nj = bj + dir[1];

            if (ni >= 0 && ni < m && nj >= 0 && nj < n && board[ni][nj] == oppoColor) {
                if (check(ni, nj, dir, m, n, board, oppoColor, color)) {
                    found = true;
                }
            }
        }
        return found;
    }

    public static boolean check(int ni, int nj, int[] dir, int m, int n, char[][] board, char oppoColor, char color) {
        boolean flag = false;

        if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
            if (board[ni][nj] == color) return true;
            else if (board[ni][nj] == oppoColor) {
                flag = update(ni + dir[0], nj + dir[1], dir, m, n, board, oppoColor, color);
            }
            else return false;
        }
        else return false;

        return flag;
    }

    public static void printBoard(char[][] board) {
        System.out.println("  0 1 2 3 4 5 6 7");

        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");

            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }
}
