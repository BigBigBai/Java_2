package bigbigbai._04_list._02_design2;

import bigbigbai._04_list._02_design2.singly.SingleLinkedList;

public class Main {
    public static void main(String[] args) {
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
