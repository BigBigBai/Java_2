package bigbigbai._12_recursion._02_distributed;

public class TailRecursion {
    public static void main(String[] args) {
        System.out.println(factorial(300));
        System.out.println(factorial2(300));
    }

    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static int factorial2(int n) {
        return factorial2(n, 1);
    }

    private static int factorial2(int n, int res) {
        if (n <= 1) return res;
        return factorial2(n - 1, res * n);
    }
}
