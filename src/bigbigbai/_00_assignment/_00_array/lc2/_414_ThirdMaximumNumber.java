package bigbigbai._00_assignment._00_array.lc2;

import java.util.TreeSet;

/**
 * Top K 问题 + 去重
 * 用TreeSet
 */
public class _414_ThirdMaximumNumber {
    // 有序集合TreeSet
    // tc: O(n)
    // sc: O(1)
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }

        return set.size() == 3 ? set.first() : set.last();
    }
}
