package bigbigbai._00_assignment._00_array.lc1;

import java.util.HashSet;

public class _217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }
}
