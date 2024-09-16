package bigbigbai._00_assignment._01_list.lc1;

import java.util.LinkedList;

/**
 * 方法1: 链地址法
 */
public class _706_DesignHashMap1 {
    private static final int BASE = 769;
    private LinkedList<Integer[]>[] lists;

    public _706_DesignHashMap1() {
        lists = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            lists[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int index = key % BASE;
        for (Integer[] data : lists[index]) {
            if (data[0] == key) {
                data[1] = value;
                return;
            }
        }
        lists[index].add(new Integer[]{key, value});
    }

    public int get(int key) {
        int index = key % BASE;
        for (Integer[] data : lists[index]) {
            if (data[0] == key) {
                return data[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % BASE;
        for (Integer[] data : lists[index]) {
            if (data[0] == key) {
                lists[index].remove(data);
                return;
            }
        }
    }
}
