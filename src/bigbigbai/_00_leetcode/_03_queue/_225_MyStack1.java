package bigbigbai._00_leetcode._03_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/implement-stack-using-queues/description/
 * 新写法
 */
public class _225_MyStack1 {
    Queue<Integer> data;
    Queue<Integer> help;

    public _225_MyStack1() {
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(int x) {
        data.offer(x);
    }

    public int pop() {
        while (data.size() > 1) help.offer(data.poll());
        int val = data.poll();

        swap();

        return val;
    }

    public int top() {
        while (data.size() > 1) help.offer(data.poll());
        int val = data.poll();
        help.offer(val);

        swap();

        return val;
    }

    public boolean empty() {
        return data.isEmpty() && help.isEmpty();
    }

    private void swap() {
        Queue<Integer> tmp = data;
        data = help;
        help = tmp;
    }
}
