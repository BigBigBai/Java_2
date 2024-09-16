package bigbigbai._00_assignment._00_array.lc2;

import java.util.Set;
import java.util.HashSet;

public class _495_TeemoAttacking {
    public int findPoisonedDuration1(int[] timeSeries, int duration) {
        int res = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i] + duration - 1 < timeSeries[i + 1]) {
                res += duration;
            } else {
                res += timeSeries[i + 1] - timeSeries[i];
            }
        }

        res += duration;

        return res;
    }

    // 哈希集合
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        Set<Integer> set = new HashSet<>();

        for (int num: timeSeries) {
            for (int i = num; i < num + duration; i++) {
                set.add(i);
            }
        }

        return set.size();
    }
}
