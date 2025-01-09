package bigbigbai._00_assignment._02_stack.lc1;

import java.util.Stack;

public class _844_BackspaceStringCompare {
    // 双指针
    // tc: O(m + n)
    // sc: O(1)
    public boolean backspaceCompare2(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            // 找到可比较值/ij越界
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else {
                    if (skipS > 0) {
                        skipS--;
                        i--;
                    } else break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else {
                    if (skipT > 0) {
                        skipT--;
                        j--;
                    } else break;
                }
            }

            if (i >= 0 && j >= 0) {
                char c1 = s.charAt(i--), c2 = t.charAt(j--);
                if (c1 != c2) return false;
            }
            else if (i >= 0) return false;
            else if (j >= 0) return false;
        }
        return true;
    }

    // 重构字符串/stack
    // tc: O(m + n)
    // sc: O(m + n)
    public boolean backspaceCompare1(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String str) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '#') {
                res.append(c);
            } else {
                if (res.length() > 0) res.deleteCharAt(res.length() - 1);
            }
        }

        return res.toString();
    }

    // stack
    // tc: O(m + n)
    // sc: O(m + n)
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != '#') stack1.push(c);
            else {
                if (!stack1.isEmpty()) stack1.pop();
            }
        }

        for (char c : t.toCharArray()) {
            if (c != '#') stack2.push(c);
            else {
                if (!stack2.isEmpty()) stack2.pop();
            }
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() != stack2.pop()) return false;
        }
        if (!stack1.isEmpty()) return false;
        if (!stack2.isEmpty()) return false;
        return true;
    }
}
