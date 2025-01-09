package bigbigbai._00_assignment._02_stack.lc2;

public class _1614_MaximumNestingDepthOfTheParentheses {
    // stack
    public int maxDepth(String s) {
        int res = 0;
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                index++;
                res = Math.max(res, index);
            } else if (c == ')') {
                index--;
            }
        }

        return res;
    }
}
