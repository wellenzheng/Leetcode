package leetcode;

import java.util.*;

public class FindLadders {
    List<List<String>> lists = new ArrayList<>();
    int maxLadder = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return lists;
        }
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }

        //构建图
        Map<String, List<String>> map = new HashMap<>();
        for (String wordi : wordList) {
            for (String wordj : wordList) {
                map.putIfAbsent(wordi, new ArrayList<>());
                if (wordi.length() == wordj.length()) {
                    int deff = 0;
                    for (int k = 0; k < wordi.length(); k++) {
                        if (wordi.charAt(k) != wordj.charAt(k)) {
                            deff++;
                        }
                    }
                    if (deff == 1) {
                        map.get(wordi).add(wordj);
                    }
                }
            }
        }

        //广度优先搜索
        Map<String, Boolean> visited = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String s : wordList) {
            visited.put(s, false);
        }
        list.add(beginWord);
        visited.replace(beginWord, true);
        dfs(map, visited, list, beginWord, endWord);
        return lists;
    }

    public void dfs(Map<String, List<String>> map, Map<String, Boolean> visited, List<String> list, String curr, String endWord) {
        if (curr.equals(endWord)) {
            if (list.size() < maxLadder) {
                lists.clear();
            }
            lists.add(new ArrayList<>(list));
            maxLadder = list.size();
            return;
        }
        if (list.size() >= maxLadder) {
            return;
        }
        for (String s : map.get(curr)) {
            if (!visited.get(s)) {
                list.add(s);
                visited.replace(s, true);
                dfs(map, visited, list, s, endWord);
                list.remove(list.size() - 1);
                visited.replace(s, false);
            }
        }
    }
}
