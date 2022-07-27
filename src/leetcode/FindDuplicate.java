package leetcode;

public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i + 1 != nums[i]) {
                int m = nums[i];
                if (m == nums[m - 1]) {
                    return m;
                } else {
                    nums[i] = nums[m - 1];
                    nums[m - 1] = m;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {8, 7, 1, 10, 17, 15, 18, 11, 16, 9, 19, 12, 5, 14, 3, 4, 2, 13, 18, 18};
        System.out.println(findDuplicate(nums));
    }
}
