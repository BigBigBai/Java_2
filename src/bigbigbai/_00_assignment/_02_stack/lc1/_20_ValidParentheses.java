package bigbigbai._00_assignment._02_stack.lc1;

import java.util.Stack;

public class _20_ValidParentheses {
    // s.replace
    // 为啥时间复杂度高？contains()

    public boolean isValid1(String s) {

        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }

        return s.isEmpty();
    }

    // stack
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                else if (c == '}' && top != '{') return false;
                else if (c == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
