package bigbigbai._00_assignment._00_array.lc2;

import java.util.ArrayList;
import java.util.List;

/**
 * (牛B)
 */
public class _448_FindAllNumbersDisappearedInAnArray {
    // 原地修改
    // tc：O(n)
    // sc: O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int index = (num - 1) % n;
            nums[index] += n;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
