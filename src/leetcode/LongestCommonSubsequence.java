package leetcode;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        int[][] dp = new int[l1][l2];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    dp[i][j] = Math.max(i == 0 ? 0 : dp[i - 1][j], j == 0 ? 0 : dp[i][j - 1]);
                }
            }
        }
        return dp[l1 - 1][l2 - 1];
    }
}
