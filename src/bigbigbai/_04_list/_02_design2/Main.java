package bigbigbai._04_list._02_design2;

import bigbigbai._04_list._02_design2.doubly.DoublyCircularLinkedList;
import bigbigbai._04_list._02_design2.doubly.JosephusRing;
import bigbigbai._04_list._02_design2.doubly.LinkedList;
import bigbigbai._04_list._02_design2.singly.ArrayList;
import bigbigbai._04_list._02_design2.singly.SingleCircularLinkedList;
import bigbigbai._04_list._02_design2.singly.SingleLinkedList;
import org.junit.Test;

public class Main {
    public static void main(String[] args) {
//        test6(8, 2);
    }


    public static void test6(int num, int step) {
        JosephusRing<Integer> list = new JosephusRing<>();
        for (int i = 1; i < num + 1; i++) list.add(i);
        list.reset();

        while (!list.isEmpty()) {
            for (int i = 0; i < step; i++) list.next();

            System.out.print(list.remove()+" ");
        }

        System.out.println();
    }

    @Test
    public void test5() {
        DoublyCircularLinkedList<String> list = new DoublyCircularLinkedList<>();
        list.add(0,"a");
        list.add(0,"b");
        list.add(0,"c");
        list.add(0,"d");

//        System.out.println(list.remove(2));
//        System.out.println(list.remove(list.size()-1));

//        while (!list.isEmpty()) {
//            System.out.println(list.remove(0));
//        }

        System.out.println();
    }

    @Test
    public void test4() {
        SingleCircularLinkedList<String> list = new SingleCircularLinkedList<>();
        list.add(0,"a");
        list.add(0,"b");
        list.add(0,"c");
        list.add(0,"d");

//        System.out.println(list.remove(2));
//        System.out.println(list.remove(list.size()-1));

        while (!list.isEmpty()) {
            System.out.println(list.remove(0));
        }

        System.out.println();
    }

    @Test
    public void test3() {
        SingleCircularLinkedList<String> list = new SingleCircularLinkedList<>();
        list.add(0,"a");
        list.add(0,"b");
        list.add(0,"c");

        System.out.println();
    }

    @Test
    public void test2() {
        LinkedList<String> list = new LinkedList<>();
        list.add(0, "a");
        list.add(0, "b");
        list.add(0, "c");

        list.remove(1);

        System.out.println();
    }

    @Test
    public void test1() {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println();
    }

    @Test
    public void test() {
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        for (int i = 0; i < 3; i++) {
            linkedList.add(0, String.valueOf((char) (i + 'a')));
        }

//        String oldEle = linkedList.set(1, null);
//        System.out.println(oldEle);
//        System.out.println(linkedList.indexOf(null));
        System.out.println(linkedList.remove(0));

        System.out.println(linkedList);
    }
}
