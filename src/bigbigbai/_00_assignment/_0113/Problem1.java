package bigbigbai._00_assignment._0113;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {
    public static void main(String[] args) {
        String input = "abcabcbb";
        String result = longestUniqueSubstring(input);
        System.out.println("Longest unique substring: " + result);
    }

    public static String longestUniqueSubstring(String input) {
        char[] chars = input.toCharArray();
        Set<Character> set = new HashSet<>(); // remove duplication
        int res = 0;
        String resString = "";
        for (int left = 0, right = 0; right < chars.length; right++) {
            char ch = chars[right];
            while (set.contains(ch)) { //
                set.remove(chars[left]);
                left++;
            }
            set.add(ch);
            if (res < right - left + 1) {
                res = right - left + 1;
                resString = input.substring(left, right + 1);
            }
        }
        return resString;
    }
}
