package leetcode;

import java.util.*;

public class ContainsNearbyAlmostDuplicate {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], true);
            }
        }
        for (int i = k; i < nums.length; i++) {

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsNearbyAlmostDuplicate(nums, 3, 0));
    }
}
