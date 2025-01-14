package bigbigbai._00_assignment._0106;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println(solution(1, 8));
    }

    public static boolean countPieces(int len, int A, int B) {
        int sticksFormed = A / len + B / len;
        return sticksFormed >= 4;
    }

    public static int solution(int A, int B) {
        int low = 1;
        int high = (A + B) / 4;
        int res = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (countPieces(mid, A, B)) {
                res = mid;
                low = mid + 1;
            } else high = mid - 1;
        }

        return res;
    }
}
