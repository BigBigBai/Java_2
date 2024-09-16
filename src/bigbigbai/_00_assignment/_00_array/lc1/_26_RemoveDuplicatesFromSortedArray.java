package bigbigbai._00_assignment._00_array.lc1;

/**
 * 双指针：
 * 一个遍历
 * 一个count不重复的值
 */
public class _26_RemoveDuplicatesFromSortedArray {
    // 双指针
    public int removeDuplicates(int[] nums) {
        int left = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[left++] = nums[i];
            }
        }

        return left;
    }
}
