package bigbigbai._00_assignment._02_stack.lc1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 做法1: 双队列
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
public class _225_ImplementStackUsingQueues1 {
    Queue<Integer> queue;
    Queue<Integer> helper;

    public _225_ImplementStackUsingQueues1() {
        queue = new LinkedList<>();
        helper = new LinkedList<>();
    }

    public void push(int x) {
        helper.add(x);

        while(!queue.isEmpty()){
            helper.add(queue.poll());
        }

        Queue<Integer> tmp = queue;
        queue = helper;
        helper = tmp;
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
