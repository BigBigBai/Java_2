package bigbigbai._00_assignment._02_stack.lc2;

import java.util.Stack;

/**
 * (((
 */
public class _1021_RemoveOutermostParentheses {
    // 计数
    // tc: O(n)
    // sc: O(n)
    public String removeOuterParentheses1(String s) {
        StringBuilder res = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                count++;
                if (count != 1) res.append(c);
            } else {
                count--;
                if (count != 0) res.append(c);
            }
        }

        return res.toString();
    }

    // stack
    // tc: O(n)
    // sc: O(n)
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
                if (stack.size() != 1) res.append(c);
            } else {
                stack.pop();
                if (stack.size() != 0) res.append(c);
            }
        }

        return res.toString();
    }
}
