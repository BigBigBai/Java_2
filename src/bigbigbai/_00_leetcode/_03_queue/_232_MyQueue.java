package bigbigbai._00_leetcode._03_queue;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 *
 */
public class _232_MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public _232_MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (inStack.isEmpty() && outStack.isEmpty()) throw new RuntimeException("queue is empty");

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) outStack.push(inStack.pop());
        }

        return outStack.pop();
    }

    public int peek() {
        if (inStack.isEmpty() && outStack.isEmpty()) throw new RuntimeException("queue is empty");

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) outStack.push(inStack.pop());
        }

        return outStack.peek();
    }

    public boolean empty() {

        return inStack.isEmpty() && outStack.isEmpty();
    }
}
