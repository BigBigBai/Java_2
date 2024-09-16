package bigbigbai._00_assignment._00_array.lc2;

public class _485_MaxConsecutiveOnes {
    // 滑动窗口
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1) count++;
            else {
                res = Math.max(res, count);
                count = 0;
            }
        }

        res = Math.max(res, count);

        return res;
    }
}
