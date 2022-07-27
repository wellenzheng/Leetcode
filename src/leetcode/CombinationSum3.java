package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n > 45) {
            return lists;
        }
        dfs(new ArrayList<>(), k, n, 1);
        return lists;
    }

    public void dfs(List<Integer> list, int k, int n, int start) {
        if (list.size() == k && n == 0) {
            lists.add(list);
            return;
        }
        if (start >= 10) {
            return;
        }
        for (int i = start; i < 10; i++) {
            list.add(i);
            dfs(list, k, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
