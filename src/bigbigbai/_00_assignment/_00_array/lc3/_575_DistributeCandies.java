package bigbigbai._00_assignment._00_array.lc3;

import java.util.HashSet;

public class _575_DistributeCandies {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(candyType[i]);
        }
        return Math.min(set.size(), (n >> 1));
    }
}
