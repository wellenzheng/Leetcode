package leetcode;

import java.util.ArrayDeque;

public class RemoveKdigits {

    public static String removeKdigits(String num, int k) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            Character poll = deque.pollFirst();
            if (leadingZero && poll == '0') {
                continue;
            }
            leadingZero = false;
            result.append(poll);
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1234567890", 9));
    }
}
