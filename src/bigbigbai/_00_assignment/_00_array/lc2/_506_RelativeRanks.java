package bigbigbai._00_assignment._00_array.lc2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _506_RelativeRanks {
    // 排序
    public String[] findRelativeRanks1(int[] score) {
        int n = score.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        String[] str = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if (i < 3) {
                res[arr[i][1]] = str[i];
            } else {
                res[arr[i][1]] = Integer.toString(i + 1);
            }
        }

        return res;
    }

    // 哈希表 + maxHeap
    // tc: O(nlogn)
    // sc: O(n)
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer,String> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int s : score) maxHeap.add(s);

        if (!maxHeap.isEmpty()) map.put(maxHeap.poll(), "Gold Medal");
        if (!maxHeap.isEmpty()) map.put(maxHeap.poll(), "Silver Medal");
        if (!maxHeap.isEmpty()) map.put(maxHeap.poll(), "Bronze Medal");
        int num = 4;
        while (!maxHeap.isEmpty()) map.put(maxHeap.poll(), "" + num++);


        String[] res = new String[score.length];
        int index = 0;
        for (int s : score) res[index++] = map.get(s);
        return res;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        maxHeap.add(11);
        maxHeap.add(4);
        maxHeap.add(23);

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }
}
