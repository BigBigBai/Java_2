package bigbigbai._00_assignment._0106;

import java.util.Arrays;

public class Problem4 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(99)));
    }

    public static int[] solution(int N) {
        for (int i = 2; i <= N; i++) {
            int A = i;
            int B = 2 * N - i;
            if (isPrime(A) && isPrime(B)) return new int[]{A, B};
        }

        return new int[]{-1, -1};
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
