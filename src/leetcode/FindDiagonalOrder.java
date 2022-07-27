package leetcode;

public class FindDiagonalOrder {

    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] list = new int[m * n];
        int turn = 1, index = 0;
        int i = 0, j = 0;
        do {
            list[index++] = matrix[i][j];
            if (turn == 1) {
                if (j == n - 1) {
                    i++;
                    turn = 0;
                } else if (i == 0) {
                    j++;
                    turn = 0;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i == m - 1) {
                    j++;
                    turn = 1;
                } else if (j == 0) {
                    i++;
                    turn = 1;
                } else {
                    i++;
                    j--;
                }
            }
        } while (index < list.length);
        return list;
    }
}
