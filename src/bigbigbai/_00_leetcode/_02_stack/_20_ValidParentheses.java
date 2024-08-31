package bigbigbai._00_leetcode._02_stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/description/
 * @author bigbigbai
 *
 * 解法1：左括号push，右括号pop
 *
 * 解法2: 动态规划
 * space complexity会低: 三个变量
 *
 */
public class _20_ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid2("(){}[]"));
        System.out.println(isValid2("(){[]}"));
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else {
                    char top = stack.pop();

                    if (top == '(' && c == ')') {}
                    else if (top == '{' && c == '}') {}
                    else if (top == '[' && c == ']') {}
                    else return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
            s = s.replace("{}", "");
            s = s.replace("[]", "");
            s = s.replace("()", "");
        }

        return s.isEmpty();
    }
}
