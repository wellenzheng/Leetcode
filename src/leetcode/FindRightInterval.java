package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {

    public static int[] findRightInterval(int[][] intervals) {
        int[][] array = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            array[i][0] = intervals[i][0];
            array[i][1] = i;
        }
        Arrays.sort(array, Comparator.comparingInt(v -> v[0]));
        int[] list = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            list[i] = find(array, end);
        }
        return list;
    }

    public static int find(int[][] array, int target) {
        if (target > array[array.length - 1][0]) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid][0] > target) {
                right = mid;
            } else if (array[mid][0] < target) {
                left = mid + 1;
            } else {
                return array[mid][1];
            }
        }
        return array[left][1];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{1, 2}, {3, 4}})));
    }
}
