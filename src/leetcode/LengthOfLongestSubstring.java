package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        int res = 0;
        char[] chs = s.toCharArray();
        Set<Character> set = new HashSet<>();
        while (r < chs.length) {
            while (r < chs.length && !set.contains(chs[r])) {
                set.add(chs[r++]);
            }
            res = Math.max(res, r - l);
            while (l < r && r < chs.length && !set.isEmpty() && set.contains(chs[r])) {
                set.remove(chs[l++]);
            }
        }
        res = Math.max(res, r - l);
        return res;
    }
}
