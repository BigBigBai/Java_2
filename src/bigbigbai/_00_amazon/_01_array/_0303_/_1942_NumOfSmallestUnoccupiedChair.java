package bigbigbai._00_amazon._01_array._0303_;

import java.util.*;

/**
 * https://leetcode.cn/problems/the-number-of-the-smallest-unoccupied-chair/description/?envType=company&envId=amazon&favoriteSlug=amazon-thirty-days
 * @author: LC
 */
public class _1942_NumOfSmallestUnoccupiedChair {
    public static void main(String[] args) {
        int[][] times = new int[][]{{1,4},{2,3},{4,6}};
        System.out.println(smallestChair(times, 1));
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        // [time, person]
        int[][] arrival = new int[times.length][2];
        int[][] leaving = new int[times.length][2];
        for (int i = 0; i < times.length; i++) {
            arrival[i][0] = times[i][0];
            arrival[i][1] = i;
            leaving[i][0] = times[i][1];
            leaving[i][1] = i;
        }
        Arrays.sort(arrival, (o1, o2) -> o1[0] - o2[0]);
        Arrays.sort(leaving, (o1, o2) -> o1[0] - o2[0]);

        // unselected chair
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) pq.offer(i);

        // person, selected chair
        Map<Integer, Integer> map = new HashMap<>();

        int lp = 0;
        for (int ap = 0; ap < times.length; ap++) {

            while (leaving[lp][0] <= arrival[ap][0]) {
                pq.offer(map.get(leaving[lp][1]));
                lp++;
            }

            map.put(arrival[ap][1], pq.poll());
            if (arrival[ap][1] == targetFriend) return map.get(arrival[ap][1]);
        }

        return -1;
    }
}
