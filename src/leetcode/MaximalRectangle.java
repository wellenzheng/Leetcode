package leetcode;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        //定义横向为长，纵向为宽，则dp记录以当前元素为结尾的长
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //若当前元素为0，则以当前元素为右下角的矩形面积为0
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + 1;
                    }

                    //从当前元素开始向上寻找最大面积，并更新最小矩形的长
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k >= 0; k--) {
                        if (matrix[k][j] == 0) break;
                        min = Math.min(min, dp[k][j]);
                        max = Math.max(max, (i - k + 1) * min);
                    }
                }
            }
        }
        return max;
    }
}
