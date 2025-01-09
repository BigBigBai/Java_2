package bigbigbai._00_assignment._03_queue.lc1;

public class _2073_TimeNeededToBuyTickets {
    // 计算每个人需要的时间
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;

        int count = tickets[k];
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                res += Math.min(tickets[i], count);
            } else {
                res += Math.min(tickets[i], count - 1);
            }
        }

        return res;
    }
}
