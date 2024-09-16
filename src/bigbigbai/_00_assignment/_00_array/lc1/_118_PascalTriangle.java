package bigbigbai._00_assignment._00_array.lc1;

import java.util.ArrayList;
import java.util.List;

public class _118_PascalTriangle {
    // 外loop：增加层数
    // 内loop：构建帕斯卡结构
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        res.add(tmp);

        for (int i = 2; i <= numRows; i++) {
            tmp = new ArrayList<>();
            tmp.add(1);

            List<Integer> prevList = res.get(res.size() - 1);
            for (int j = 1; j < prevList.size(); j++) {
                tmp.add(prevList.get(j - 1) + prevList.get(j));
            }

            tmp.add(1);
            res.add(tmp);
        }

        return res;
    }
}
