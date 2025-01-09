package bigbigbai._00_assignment._02_stack.lc1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 做法2: 单队列
 *
 * time complexity:
 * push() : O(n)
 * pop(): O(1)
 * top(): O(1)
 * empty(): O(1)
 * 
 * space complexity:
 * O(n)
 */
public class _225_ImplementStackUsingQueues2 {
    Queue<Integer> queue;

    public _225_ImplementStackUsingQueues2() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.offer(x);

        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
