package bigbigbai._00_assignment._02_stack.lc1;

import java.util.Stack;

/**
 * 做法1: 双栈
 *
 * time complexity:
 * push(): O(1)
 * pop(): 均摊O(1)
 * peek(): 均摊O(1)
 * empty(): O(1)
 * 对于每个元素，出栈入栈各两次
 *
 * space complexity:
 * O(n)
 */
public class _232_ImplementQueueUsingStacks {
    Stack<Integer> stack;
    Stack<Integer> helper;

    public _232_ImplementQueueUsingStacks() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if (!helper.isEmpty()) return helper.pop();

        while (!stack.isEmpty()) helper.push(stack.pop());
        return helper.pop();
    }

    public int peek() {
        if (!helper.isEmpty()) return helper.peek();

        while (!stack.isEmpty()) helper.push(stack.pop());
        return helper.peek();
    }

    public boolean empty() {
        return stack.isEmpty() && helper.isEmpty();
    }
}
