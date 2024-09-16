package bigbigbai._00_assignment._00_array.lc2;

import java.util.Arrays;
import java.util.HashMap;

public class _500_KeyboardRow {
    // 哈希表
    public String[] findWords(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        String[] letters = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int ind = 0;
        for (String letter : letters) {
            for (int i = 0; i < letter.length(); i++) {
                map.put(letter.charAt(i), ind);
            }
            ind++;
        }

        String[] res = new String[words.length];
        int index = 0;
        for (String word : words) {
            int val = map.get(Character.toLowerCase(word.charAt(0)));

            int i = 1;
            while (i < word.length()) {
                int val1 = map.get(Character.toLowerCase(word.charAt(i)));
                if (val1 != val) break;
                i++;
            }

            if (i == word.length()) res[index++] = word;
        }

        return Arrays.copyOfRange(res, 0, index);
    }
}
