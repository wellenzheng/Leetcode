package leetcode;

import java.util.*;

public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
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
        Queue<String> queue = new ArrayDeque<>();
        Map<String, Boolean> visited = new HashMap<>();
        int count = 0;
        queue.add(beginWord);
        for (String s : wordList) {
            visited.put(s, false);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                visited.replace(poll, true);
                for (String next : map.get(poll)) {
                    if (next.equals(endWord)) {
                        return count;
                    }
                    if (!visited.get(next)) {
                        queue.add(next);
                    }
                }
            }
        }

        return 0;
    }
}
