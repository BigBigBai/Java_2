package bigbigbai._12_recursion._01_recursive;

public class NumsOfCows {
    public int numsOfCows(int n) {
        if (n <= 4) return n;
        return numsOfCows(n - 1) + numsOfCows(n - 3);
    }
}
