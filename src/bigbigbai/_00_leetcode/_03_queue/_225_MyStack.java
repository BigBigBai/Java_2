package bigbigbai._00_leetcode._03_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/implement-stack-using-queues/description/
 * 旧写法
 */
public class _225_MyStack {
    Queue<Integer> data;
    Queue<Integer> help;

    public _225_MyStack() {
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(int x) {
        if (!help.isEmpty()) help.add(x);
        else data.add(x);
    }

    public int pop() {
        int size;
        if (!help.isEmpty()) {
            size = help.size();
            for (int i = 0; i < size- 1; i++) data.add(help.remove());
            return help.remove();
        } else {
            size = data.size();
            for (int i = 0; i < size - 1; i++) help.add(data.remove());
            return data.remove();
        }
    }

    public int top() {
        int val;
        int size;
        if (!help.isEmpty()) {
            size = help.size();
            for (int i = 0; i < size - 1; i++) data.add(help.remove());
            val = help.remove();
            data.add(val);
        } else {
            size = data.size();
            for (int i = 0; i < size - 1; i++) help.add(data.remove());
            val = data.remove();
            help.add(val);
        }

        return val;
    }

    public boolean empty() {
        return data.isEmpty() && help.isEmpty();
    }

}
