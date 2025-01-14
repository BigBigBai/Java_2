package bigbigbai._00_assignment._0106;

import java.util.Arrays;

public class Problem3 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution("VHV")));
    }

    public static int[][] solution(String s) {
        char[] chars = s.toCharArray();
        int countV = 0;
        int countH = 0;
        for (char ch : chars) {
            if (ch == 'V') countV++;
            else countH++;
        }

        countV %= 2;
        countH %= 2;

        if (countV == 1 && countH == 1) return new int[][]{{4,3}, {2,1}};
        else if (countV == 1) return new int[][]{{2,1}, {4,3}};
        else if (countH == 1) return new int[][]{{3,4}, {1,2}};
        return new int[][]{{1,2}, {3,4}};
    }
}
