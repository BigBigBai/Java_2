package bigbigbai._00_leetcode._02_stack;

import java.util.LinkedList;

/**
 * 链表
 */
public class _155_MinStack {
    private Node head;

    private class Node {
        int val;
        Node next;
        int min;

        public Node(int val, Node next, int min) {
            this.val = val;
            this.next = next;
            this.min = min;
        }
    }

    public _155_MinStack() {
        head = new Node(0, null, Integer.MAX_VALUE);
    }

    public void push(int val) {
        Node node = new Node(val, head, Math.min(val, head.min));
        head = node;
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

}
