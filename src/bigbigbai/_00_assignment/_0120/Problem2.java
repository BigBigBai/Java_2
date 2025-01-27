package bigbigbai._00_assignment._0120;

import java.util.ArrayList;
import java.util.List;

/**
 * Find number of nodes on the longest distinct path
 */
public class Problem2 {
    public static void main(String[] args) {
        Tree A = new Tree(1);
        Tree B = new Tree(2);
        Tree C = new Tree(3);
        Tree D = new Tree(3);
        Tree E = new Tree(6);
        Tree F = new Tree(3);
        Tree G = new Tree(1);
        Tree H = new Tree(2);
        Tree I = new Tree(5);
        Tree J = new Tree(6);

        A.l = B;
        A.r = C;
        B.l = D;
        B.r = E;
        C.l = F;
        C.r = G;
        D.l = H;
        G.l = I;
        G.r = J;

        Tree K = new Tree(3);
        E.l = K;

        System.out.println(solution(A));
    }

    public static int solution(Tree T) {
        if (T == null) return 0;

        List<Integer> list = new ArrayList<>();
        list.add(T.x);

        int longest = Math.max(solution(T.l, list), solution(T.r, list)) + 1;
        list.remove(list.size() - 1);
        return longest;
    }

    public static int solution(Tree T, List<Integer> list) {
        if (T == null) return 0;
        if (list.contains(T.x)) return 0;

        list.add(T.x);
        int longest = Math.max(solution(T.l, list), solution(T.r, list)) + 1;
        list.remove(list.size() - 1);
        return longest;
    }


}
