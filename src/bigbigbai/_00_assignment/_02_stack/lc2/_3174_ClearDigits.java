package bigbigbai._00_assignment._02_stack.lc2;

public class _3174_ClearDigits {
    // stack
    public String clearDigits(String s) {
        char[] chars = s.toCharArray();
        int index = 0;

        for (char c : chars) {
            if (index != 0 && (c >= '0' && c <= '9')) {
                index--;
            } else {
                chars[index++] = c;
            }
        }

        return new String(chars, 0, index);
    }
}
