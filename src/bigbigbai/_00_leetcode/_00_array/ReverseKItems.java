package bigbigbai._00_leetcode._00_array;

import java.util.Arrays;

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */
public class ReverseKItems {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int k = 3;
        reverseKItems(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverseKItems(int[] nums, int k) {
        int count = nums.length/k;
        int j = 0;
        for (int i = 0; i < count; i++) {
            reverse(nums, j, j+k);
            j += k;
        }
    }

    public static void reverse(int[] nums, int left, int right) {
        right--;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
