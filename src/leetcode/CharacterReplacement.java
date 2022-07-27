package leetcode;

public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int maxCount = 0;
        int res = 0;
        int[] count = new int[26];
        while (right < s.length()) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            right++;
            if (right - left > maxCount + k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
