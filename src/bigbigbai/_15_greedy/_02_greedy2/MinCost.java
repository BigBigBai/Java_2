package bigbigbai._15_greedy._02_greedy2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCost {
    public static void main(String[] args) {
        System.out.println(minCost2(new int[]{20, 10, 30, 40, 50}));
    }

    public static int minCost2(int[] arr) {
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int data : arr) pq.add(data);
        while (pq.size() > 1) {
            int subCost = pq.poll() + pq.poll();
            cost += subCost;
            pq.add(subCost);// (NB)
        }

        return cost;
    }


    public static int minCost(int[] arr) {
        Arrays.sort(arr);
        int cost = 0;

        for (int i = arr.length - 1; i > 0; i--) {
            int subCost = sum(arr, i);
            cost += subCost;
        }

        return cost;
    }

    public static int sum(int[] arr ,int len) {
        int res = 0;
        for (int i = len; i >= 0; i--) {
            res += arr[i];
        }
        return res;
    }
}
