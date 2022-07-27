import java.util.*;

public class Main {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return list;
        }
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] <= nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
            if (p1 * p2 >= k) {
                break;
            }
        }
        while (p1 * p2 < k) {
            if (p1 < nums1.length) {
                p1++;
            }
            if (p2 < nums2.length) {
                p2++;
            }
            if (p1 == nums1.length && p2 == nums2.length) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 1, 2};
        int[] num2 = {1, 2, 3};
        System.out.println(kSmallestPairs(num1, num2, 8));
    }
}