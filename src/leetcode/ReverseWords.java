package leetcode;

import java.util.Arrays;

public class ReverseWords {

    public String reverseWords(String s) {
        String[] split = s.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].length() > 0) {
                stringBuilder.append(split[i]).append(" ");
            }
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("  word   ow".split("\\s+")));
    }
}
