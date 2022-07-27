package leetcode;

public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        while (right < nums.length) {
            while (sum < s && right < nums.length) {
                sum += nums[right++];
            }
            while (sum >= s && left <= right) {
                length = Math.min(length, right - left);
                sum -= nums[left++];
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
