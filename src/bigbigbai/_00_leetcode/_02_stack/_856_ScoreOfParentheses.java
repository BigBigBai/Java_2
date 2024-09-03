package bigbigbai._00_leetcode._02_stack;

import java.util.Stack;

public class _856_ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            }
            else {
                stack.pop();
                sum++;
            }

        }

        return res;
    }
}
