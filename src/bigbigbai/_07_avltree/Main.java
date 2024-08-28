package bigbigbai._07_avltree;

import bigbigbai._07_avltree.printer.BinaryTrees;
import org.junit.Test;

public class Main {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.add(11);
        avlTree.add(6);
        avlTree.add(4);
        avlTree.add(8);
        avlTree.add(15);
        avlTree.add(14);
        avlTree.add(16);
        avlTree.add(12);

        BinaryTrees.print(avlTree);
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");


        avlTree.remove(16);
        BinaryTrees.print(avlTree);
    }
}
