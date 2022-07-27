package leetcode;

import java.util.Arrays;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        int[] sorted = Arrays.stream(nums).boxed().sorted((i, j) -> {
            String num1 = String.valueOf(i) + j;
            String num2 = String.valueOf(j) + i;
            return num1.compareTo(num2);
        }).mapToInt(i -> i).toArray();
        StringBuilder sb = new StringBuilder();
        for (int i : sorted) {
            sb.append(i);
        }
        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }
}
