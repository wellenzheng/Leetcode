package leetcode;

public class NumDistinct {
    public static int count = 0;

    public static int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return count;
        }
        dfs(s, t, 0, new StringBuilder());
        return count;
    }

    public static void dfs(String s, String t, int start, StringBuilder sb) {
        if (!t.startsWith(sb.toString())) {
            return;
        }
        if (sb.toString().equals(t)) {
            count++;
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (t.startsWith(sb.toString())) {
                sb.append(s.charAt(i));
                dfs(s, t, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                dfs(s, t, i + 1, sb);
            }
        }
    }

    public static void main(String[] args) {
        String s = "anacondastreetracecar", t = "contra";
        System.out.println(numDistinct(s, t));
    }
}
