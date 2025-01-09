package bigbigbai._00_assignment._03_queue.lc1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue
 */
public class _933_NumberOfRecentCalls {
    Queue<Integer> queue;

    public _933_NumberOfRecentCalls() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        queue.offer(t);

        return queue.size();
    }
}
