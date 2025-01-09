package bigbigbai._00_assignment._02_stack.lc2;

import java.util.Stack;

/**
 *
 */
public class _1544_MakeTheStringGreat {
    // stack: char[]
    public String makeGood1(String s) {
        char[] res = new char[s.length()];
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (index != 0 && Math.abs(res[index - 1] - c) == 32) {
                index--;
            } else {
                res[index++] = c;
            }
        }

        return new String(res, 0, index);
    }

    // stack: StringBuilder
    public String makeGood(String s) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (res.length() != 0 && Math.abs(res.charAt(res.length() - 1) - c) == 32) {
                res.deleteCharAt(res.length() - 1);
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}
