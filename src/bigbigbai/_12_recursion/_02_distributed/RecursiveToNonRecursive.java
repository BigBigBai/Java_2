package bigbigbai._12_recursion._02_distributed;

import java.util.Stack;

public class RecursiveToNonRecursive {
    public static void main(String[] args) {
        log2(4);
    }

    public static void log(int n) {
        if (n < 1) return;
        log(n - 1);
        int v = n + 10;
        System.out.println(v);
    }

    public static void log2(int n) {
        if (n < 1) return;

        Stack<Frame> stack = new Stack<Frame>();

        //simulate system pushing
        while (n > 0) {
            stack.push(new Frame(n, n + 10));
            n--;
        }

        //simulate system popping
        while (!stack.isEmpty()) {
            Frame frame = stack.pop();
            System.out.println(frame.v);
        }
    }

    private static class Frame {
        int n;
        int v;

        Frame(int n, int v) {
            this.n = n;
            this.v = v;
        }
    }

    public static void log3(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(n + 10);
        }
    }
}
