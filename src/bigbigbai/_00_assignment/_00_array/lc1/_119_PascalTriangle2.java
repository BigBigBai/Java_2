package bigbigbai._00_assignment._00_array.lc1;

import java.util.ArrayList;
import java.util.List;

public class _119_PascalTriangle2 {
    // 内loop：原地更新data
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex == 0) return res;

        for (int i = 1; i <= rowIndex; i++) {
            int prev = 1;
            for (int j = 1; j < res.size(); j++) {
                int tmp = res.get(j);
                res.set(j, prev + tmp);
                prev = tmp;
            }

            res.add(1);
        }

        return res;
    }
}
