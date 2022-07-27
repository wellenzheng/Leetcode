package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses {

    List<String> list = new ArrayList<>();
    int maxLength = 0;

    public List<String> removeInvalidParentheses(String s) {
        dfs(s, new StringBuilder(), 0);
        return list;
    }

    public void dfs(String s, StringBuilder sb, int index) {
        if (index == s.length()) {
            if (sb.length() >= maxLength && isValid(sb.toString())) {
                if (sb.length() > maxLength) {
                    list.clear();
                }
                if (!list.contains(sb.toString())) {
                    list.add(sb.toString());
                }
            }
            return;
        }

        sb.append(s.charAt(index));
        dfs(s, sb, index + 1);
        sb.deleteCharAt(sb.length() - 1);

        dfs(s, sb, index + 1);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
