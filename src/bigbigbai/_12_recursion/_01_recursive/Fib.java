package bigbigbai._12_recursion._01_recursive;

public class Fib {
    public static void main(String[] args) {
        System.out.println(fib6(4));
    }

    public int fib5(int n) {
        if (n <= 1) return n;
        int[] arr = new int[2];

        arr[0] = 1;
        arr[1] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i%2] = arr[(i-1)%2] + arr[(i-2)%2];// & 1
        }

        return arr[n%2];
    }

    public int fib4(int n) {
        if (n <= 1) return n;
        int first = 1;
        int second = 1;
        for (int i = 3; i <= n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }

    public int fib3(int n) {
        if (n <= 1) return n;
        int[] arr = new int[n+1];

        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];
    }

    public int fib2(int n) {
        if (n <= 1) return n;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;

        return fib2(n, arr);
    }

    public int fib2(int n, int[] arr) {
        if (arr[n] == 0) arr[n] = fib2(n-1, arr) + fib2(n-2, arr);

        return arr[n];
    }

    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }

    public static int fib6(int n) {
        if (n <= 1) return n;

        return fib6(n, 1, 1);
    }

    private static int fib6(int n, int first, int second) {
        if (n <= 1) return second;

        return fib6(n - 1, second, first + second);
    }
}
