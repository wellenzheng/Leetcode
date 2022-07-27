package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] list = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(nums[i]);
        }
        list[0] = queue.peekFirst();
        for (int i = k; i < nums.length; i++) {
            System.out.println(queue);
            while (!queue.isEmpty() && queue.peekLast() <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(nums[i]);
            while (queue.size() > k) {
                queue.pollFirst();
            }
            list[i - k + 1] = queue.peekFirst();
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
    }
}
