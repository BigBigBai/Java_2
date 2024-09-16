package bigbigbai._00_assignment._00_array.lc1;

import java.util.ArrayList;
import java.util.List;

public class _228_SummaryRanges {
    public static void main(String[] args) {
        int a = -2147483648;
        int b = -2147483647;
        int c = 2147483647;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(c - b);
    }

    // 双指针
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        int prevNum = nums[0];
        int preIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                if (i - preIndex == 1) res.add(String.valueOf(prevNum));
                else res.add(prevNum + "->" + nums[i - 1]);

                prevNum = nums[i];
                preIndex = i;
            }
        }

        if (preIndex == nums.length - 1) res.add(String.valueOf(prevNum));
        else res.add(prevNum + "->" + nums[nums.length - 1]);

        return res;
    }
}
