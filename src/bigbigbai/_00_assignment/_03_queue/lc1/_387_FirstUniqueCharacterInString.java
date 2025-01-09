package bigbigbai._00_assignment._03_queue.lc1;

import java.util.HashMap;

public class _387_FirstUniqueCharacterInString {
    // HashMap
    // tc: O(n)
    // sc: O(26) 26个小写字母
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
