package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int m = nums[i] - 1;
            if (nums[m] > 0) {
                nums[m] = -nums[m];
            } else {
                list.add(m + 1);
            }
        }
        return list;
    }
}
