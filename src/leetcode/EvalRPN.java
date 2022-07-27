package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvalRPN {
    static List<String> ops = Arrays.asList("+", "-", "*", "/");

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (ops.contains(token)) {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                switch (token) {
                    case "+":
                        stack.push(String.valueOf(num2 + num1));
                        break;
                    case "-":
                        stack.push(String.valueOf(num2 - num1));
                        break;
                    case "*":
                        stack.push(String.valueOf(num2 * num1));
                        break;
                    case "/":
                        stack.push(String.valueOf(num2 / num1));
                        break;
                }
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] strings = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(strings));
    }
}
