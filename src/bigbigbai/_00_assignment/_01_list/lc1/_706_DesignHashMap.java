package bigbigbai._00_assignment._01_list.lc1;

import java.util.LinkedList;
import java.util.List;

public class _706_DesignHashMap {
    private List<int[]> lists;

    public _706_DesignHashMap() {
        lists = new LinkedList<>();
    }

    public void put(int key, int value) {
        for (int[] list : lists) {
            if (list[0] == key) {
                list[1] = value;
                return;
            }
        }
        lists.add(new int[]{key, value});
    }

    public int get(int key) {
        for (int[] list : lists) {
            if (list[0] == key) {
                return list[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        for (int[] list : lists) {
            if (list[0] == key) {
                lists.remove(list);
                return;
            }
        }
    }
}
