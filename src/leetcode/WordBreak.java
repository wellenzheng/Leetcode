package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    static List<String> list = new ArrayList<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
//        boolean[] dp = new boolean[s.length() + 1];
//        dp[0] = true;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < i; j++) {
//                if (dp[j] && wordDict.contains(s.substring(j, i))) {
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }
        dfs(new StringBuilder(s), new StringBuilder(), wordDict);
        return list;
    }

    public static void dfs(StringBuilder origin, StringBuilder target, List<String> wordDict) {
        if (origin.length() == 0) {
            list.add(target.substring(1));
            return;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            if (origin.toString().startsWith(wordDict.get(i))) {
                origin.delete(0, wordDict.get(i).length());
                target.append(" ").append(wordDict.get(i));
                dfs(origin, target, wordDict);
                origin.insert(0, wordDict.get(i));
                target.delete(target.length() - wordDict.get(i).length() - 1, target.length());
            }
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> list = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(wordBreak(s, list));
    }
}
