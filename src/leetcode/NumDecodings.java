package leetcode;

public class NumDecodings {

    public static int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            String sub = s.substring(i - 1, i + 1);
            if (s.charAt(i) != '0') {
                dp[i] += dp[i - 1];
            }
            if (!sub.startsWith("0") && sub.compareTo("26") <= 0) {
                if (i == 1) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("200"));
    }
}
