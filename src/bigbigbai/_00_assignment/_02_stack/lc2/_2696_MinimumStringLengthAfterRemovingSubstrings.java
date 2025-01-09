package bigbigbai._00_assignment._02_stack.lc2;

public class _2696_MinimumStringLengthAfterRemovingSubstrings {
    // stack
    public int minLength(String s) {
        char[] chars = s.toCharArray();
        int index = 0;

        for (char c : chars) {
            if (index != 0 && ((chars[index - 1] == 'A' && c == 'B') || (chars[index - 1] == 'C' && c == 'D'))) {
                index--;
            } else {
                chars[index++] = c;
            }
        }

        return index;
    }
}
