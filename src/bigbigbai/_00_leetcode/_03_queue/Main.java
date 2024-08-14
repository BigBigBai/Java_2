package bigbigbai._00_leetcode._03_queue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
    }

    @Test
    public void test() {
        _225_MyStack myStack = new _225_MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());
    }
}
