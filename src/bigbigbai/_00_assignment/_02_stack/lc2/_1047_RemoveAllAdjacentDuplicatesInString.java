package bigbigbai._00_assignment._02_stack.lc2;

import java.util.Stack;

public class _1047_RemoveAllAdjacentDuplicatesInString {
    // stack: char[]
    public String removeDuplicates2(String s) {
        char[] res = s.toCharArray();
        int index = 0;

        for (char c : res) {
            if (index == 0 || res[index - 1] != c) {
                res[index++] = c;
            } else {
                index--;
            }
        }

        return new String(res, 0, index);
    }

    // stack: StringBuilder
    public String removeDuplicates1(String s) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (res.length() == 0 || res.charAt(res.length()-1) != c) {
                res.append(c);
            } else {
                res.deleteCharAt(res.length()-1);
            }
        }

        return res.toString();
    }

    // stack: Stack<Character>
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        stack.push('a');
        stack.push('b');
        System.out.println(stack.toString());
    }
}
