package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SolveSudoku {

    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] grid = new boolean[3][3][9];
    boolean valid = false;

    public void solveSudoku(char[][] board) {
        List<int[]> black = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    black.add(new int[]{i, j});
                } else {
                    row[i][board[i][j] - '1'] = true;
                    col[j][board[i][j] - '1'] = true;
                    grid[i / 3][j / 3][board[i][j] - '1'] = true;
                }
            }
        }
        dfs(board, black, 0);
    }

    public void dfs(char[][] board, List<int[]> black, int index) {
        if (index == black.size()) {
            valid = true;
            return;
        }

        int[] pos = black.get(index);
        int i = pos[0], j = pos[1];
        for (int num = 0; num < 9 && !valid; num++) {
            if (!row[i][num] && !col[j][num] && !grid[i / 3][j / 3][num]) {
                row[i][num] = col[j][num] = grid[i / 3][j / 3][num] = true;
                board[i][j] = (char) (num + '0' + 1);
                dfs(board, black, index++);
                row[i][num] = col[j][num] = grid[i / 3][j / 3][num] = false;
            }
        }
    }
}
