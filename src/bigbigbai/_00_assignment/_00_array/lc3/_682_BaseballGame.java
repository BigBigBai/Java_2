package bigbigbai._00_assignment._00_array.lc3;

import java.util.ArrayList;
import java.util.List;

public class _682_BaseballGame {
    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for (String operation : operations) {
            switch (operation) {
                case "C":
                    list.remove(list.size() - 1);
                    break;
                case "D":
                    int cur = list.get(list.size() - 1);
                    list.add(cur * 2);
                    break;
                case "+":
                    int prev = list.get(list.size() - 2);
                    int cur1 = list.get(list.size() - 1);
                    list.add(prev + cur1);
                    break;
                default:
                    list.add(Integer.valueOf(operation));
            }
        }

        int res = 0;
        for (int num : list) res += num;
        return res;
    }

    public static void main(String[] args) {
        String a = "a";
        String b = a;
        System.out.println(a == b);
    }
}
