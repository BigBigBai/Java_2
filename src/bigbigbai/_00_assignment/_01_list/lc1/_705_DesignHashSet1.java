package bigbigbai._00_assignment._01_list.lc1;

import java.util.LinkedList;
import java.util.List;

/**
 * 方法1: 链地址法
 * n: 哈希表中的元素数量
 * b: 链表的数量
 * tc: O(n/b)
 * sc: O(n + b)
 */
public class _705_DesignHashSet1 {
    private static final int BASE  = 769;
    private LinkedList<Integer>[] lists;

    public _705_DesignHashSet1() {
        lists = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            lists[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int index = key % BASE;
        for (int num: lists[index]) {
            if (num == key) return;
        }
        lists[index].add(key);
    }

    public boolean contains(int key) {
        int index = key % BASE;
        for (int num: lists[index]) {
            if (num == key) return true;
        }
        return false;
    }

    public void remove(int key) {
        int index = key % BASE;
        for (int num: lists[index]) {
            if (num == key) {
                lists[index].remove((Object)num); // (牛B)
                return;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < BASE; i++) {
            list.add(new LinkedList<>());
        }

        List<Integer> res = new LinkedList<>();
        for (int num: res) {
            System.out.println(num);
        }
    }
}
