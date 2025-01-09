package bigbigbai._00_assignment._02_stack.lc2;

import java.util.Arrays;
import java.util.Stack;

/**
 * 额外思路：单调栈（递增）+ 倒叙check
 */
public class _1475_FinalPricesWithSpecialDiscountInShop {
    // 单调栈（递增）
    public static int[] finalPrices(int[] prices) {
        int[] res = Arrays.copyOf(prices, prices.length);
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.peek().val >= prices[i]) {
                Pair pair = stack.pop();
                res[pair.index] = pair.val - prices[i];
            }

            stack.push(new Pair(prices[i], i));
        }

        return res;
    }

    private static class Pair {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices(new int[]{8,4,6,2,3})));
    }
}
