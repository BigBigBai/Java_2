package bigbigbai._00_assignment._01_list.lc1;

import java.util.LinkedList;
import java.util.List;

public class _705_DesignHashSet {
    List<Integer> list;

    public _705_DesignHashSet() {
        list = new LinkedList<>();
    }

    public void add(int key) {
        if (!list.contains(key)) {
            list.add(key);
        }
    }

    public void remove(int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) {
                list.remove(i);
                break;
            }
        }
    }

    public boolean contains(int key) {
        return list.contains(key);
    }
}
