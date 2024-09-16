package bigbigbai._00_assignment._00_array.lc1;

public class _121_BestTimeToBuyAndSellStock {
    // 双指针buy/sell
    public int maxProfit(int[] prices) {
        int res = 0;
        int buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int sell = prices[i];
            res = Math.max(res, sell - buy);
            if (sell < buy) buy = sell;
        }

        return res;
    }
}
