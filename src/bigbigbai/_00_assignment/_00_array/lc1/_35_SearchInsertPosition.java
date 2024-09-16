package bigbigbai._00_assignment._00_array.lc1;

/**
 * Input: nums = [1,3,5,6], target = 3      // 1
 * Input: nums = [1,3,5,6], target = 4      // 2
 * Input: nums = [1,3,5,6], target = 10     // 4
 * Input: nums = [1,3,5,6], target = -10    // 0
 */
public class _35_SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = -10;
        System.out.println(searchInsert(nums, target));
    }

    // 二分法
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
