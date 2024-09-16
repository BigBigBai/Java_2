package bigbigbai._00_assignment._00_array.lc2;

public class _283_MoveZeros {
    // 双指针
    public void moveZeroes(int[] nums) {
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[left++] = nums[i];
                if (i != left - 1) nums[i] = 0;
            }
        }
    }
}
