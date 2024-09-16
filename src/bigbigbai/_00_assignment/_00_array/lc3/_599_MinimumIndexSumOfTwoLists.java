package bigbigbai._00_assignment._00_array.lc3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _599_MinimumIndexSumOfTwoLists {
    // 哈希表
    public String[] findRestaurant1(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) map.put(list1[i], i);

        List<String> res = new ArrayList<>();
        int resNum = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int j = map.get(list2[i]);
                if (i + j < resNum) {
                    resNum = i + j;
                    res.clear();
                    res.add(list2[i]);
                } else if (i + j == resNum) {
                    res.add(list2[i]);
                }
            }
        }

        return res.toArray(new String[0]);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) map1.put(list1[i], i);

        int num = Integer.MAX_VALUE;
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                map2.put(list2[i], i + map1.get(list2[i]));
                num = Math.min(num, map2.get(list2[i]));
            }
        }

        String[] res = new String[list1.length];
        int index = 0;
        for (String s : map2.keySet()) {
            if (map2.get(s) == num) res[index++] = s;
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}
