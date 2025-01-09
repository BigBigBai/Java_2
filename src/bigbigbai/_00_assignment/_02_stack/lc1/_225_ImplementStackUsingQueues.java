package bigbigbai._00_assignment._02_stack.lc1;

import java.util.LinkedList;
import java.util.Queue;

public class _225_ImplementStackUsingQueues {
    Queue<Integer> queue;
    Queue<Integer> helper;

    public _225_ImplementStackUsingQueues() {
        queue = new LinkedList<>();
        helper = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            helper.add(queue.poll());
        }
        int ele = queue.poll();

        Queue<Integer> tmp = queue;
        queue = helper;
        helper = tmp;

        return ele;
    }

    public int top() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            helper.add(queue.poll());
        }
        int ele = queue.poll();
        helper.add(ele);

        Queue<Integer> tmp = queue;
        queue = helper;
        helper = tmp;

        return ele;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
