package leetcode;

import java.util.Arrays;

class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = (j == 0 ? 0 : dp[i][j - 1]) + matrix[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = dp[row2][col2];
        if (row1 != 0) {
            res -= dp[row1 - 1][col2];
        }
        if (col1 != 0) {
            res -= dp[row2][col1 - 1];
        }
        if (row1 != 0 && col1 != 0) {
            res += dp[row1 - 1][col1 - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{-1}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(0, 0, 0, 0));
    }
}
