package bigbigbai._02_complexity;

public class _509_Fib {
    public static void main(String[] args) {
        System.out.println(fib3(4));
    }


    //动态规划
    public static int fib4(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    //双指针
    public static int fib3(int n) {
        if (n <= 1) return n;

        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {// n-1 represent calculating fib(n), need addition's times
            int sum = first + second;
            first = second;
            second = sum;
        }

        return second;
    }

    //在递归过程中，数据共享的方法：
    //1.作为递归函数的参数进行传递
    //2.把需要共享的数据做成成员变量
    public static int fib2(int n) {
        if (n <= 1) return n;

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;

        return fib2(n, arr);
    }

    //马甲方法 Inner method
    private static int fib2(int n, int[] arr) {
        if (arr[n] == 0) arr[n] = fib2(n - 1, arr) + fib2(n - 2, arr);

        return arr[n];
    }

    //递归
    public static int fib(int n) {
        if (n <= 1) return n;

        return fib(n - 1) + fib(n - 2);
    }
}
