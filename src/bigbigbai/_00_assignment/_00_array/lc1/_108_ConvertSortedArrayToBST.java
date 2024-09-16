package bigbigbai._00_assignment._00_array.lc1;

import bigbigbai._00_assignment.TreeNode;

/**
 * Input: nums = [-10,-3,0,5,9]
 */
public class _108_ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);

        return root;
    }
}
