package bigbigbai._19_sort.non_cmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _09_BucketSort {
    public static void main(String[] args) {
        Double[] arr = {0.34, 0.47, 0.29, 0.84, 0.45, 0.38, 0.35, 0.76};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Thought:
     * 1. create an amount of bucket(array/linked list(recommend))
     * 2. follow the rule, to distribute the element to different bucket even
     * 3. sort each bucket separately
     * 4. put all non-zero bucket concatenating to sorted array
     *
     * @author: Dal
     */
    public static void sort(Double[] arr) {
        if (arr == null || arr.length < 2) return;

        // 1. create an amount of bucket(array/linked list(recommend))
        List<Double>[] buckets = new List[arr.length];

        // 2. follow the rule, to distribute the element to different bucket even
        for (int i = 0; i < arr.length; i++) {
            // rule: element value * number of bucket
            int bucketIndex = (int) (arr[i] * buckets.length);
            List<Double> bucket = buckets[bucketIndex];

            if (bucket == null) {
                bucket = new ArrayList<>();
                buckets[bucketIndex] = bucket;
            }
            bucket.add(arr[i]);
        }

        // 3. sort each bucket separately
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            buckets[i].sort(null);

            // 4. put all non-zero bucket concatenating to sorted array
            for (Double d : buckets[i]) {
                arr[index++] = d;
            }
        }

    }
}
