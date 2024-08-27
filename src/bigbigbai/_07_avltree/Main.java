package bigbigbai._07_avltree;

import org.junit.Test;

public class Main {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        for (int i = 0; i < 10; i++) {
            avlTree.add(i);
        }

        System.out.println();
    }
}
