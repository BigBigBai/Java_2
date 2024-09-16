package bigbigbai._00_assignment._00_array.lc1;

/**
 *
 */
public class _27_RemoveElement {
    // 双指针
    public int removeElement(int[] nums, int val) {
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[left++] = nums[i];
            }
        }

        return left;
    }
}
