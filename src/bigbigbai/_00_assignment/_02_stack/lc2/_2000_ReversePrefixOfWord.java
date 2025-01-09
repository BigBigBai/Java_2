package bigbigbai._00_assignment._02_stack.lc2;

public class _2000_ReversePrefixOfWord {
    // stack
    public String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        int index = 0;
        for (char c : chars) {
            if (c == ch) break;
            index++;
        }
        if (index == word.length()) return word;

        // 反转
        int left = 0;
        int right = index;
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
