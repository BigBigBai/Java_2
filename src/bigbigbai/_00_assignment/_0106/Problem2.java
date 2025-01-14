package bigbigbai._00_assignment._0106;

public class Problem2 {
    public static void main(String[] args) {
        int[] A = {1,3};
        int[] B = {2,2};
        System.out.println(solution(3, A, B));
    }

    public static boolean solution(int N, int[] A, int[] B) {
        int num = N * (N - 1) / 2;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - B[i]) == 1) {
                int min = Math.min(A[i], B[i]);
                sum += min;
            }
        }

        return  sum == num;
    }
}
