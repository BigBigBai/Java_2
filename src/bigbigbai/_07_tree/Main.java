package bigbigbai._07_tree;

import bigbigbai._07_tree.printer.BinaryTrees;
import bigbigbai._07_tree.BinaryTree.Node;
import org.junit.Test;

public class Main {
    public static void main(String[] args) {

    }

    @Test
    public void test2() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(9);
        bst.add(11);
        bst.add(10);
        bst.add(12);

        bst.remove(10);

        BinaryTrees.print(bst);
    }

    @Test
    public void test1() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(8);
        bst.add(3);
        bst.add(10);
        bst.add(1);
        bst.add(6);
        bst.add(14);
        bst.add(4);
        bst.add(7);
        bst.add(13);

//        System.out.println(bst.predecessor(bst.node(8)));
//        System.out.println(bst.successor(bst.node(8)));
//        System.out.println(bst.contains(12));
//        System.out.println(bst.size());
//        System.out.println(bst.height());

        BinaryTrees.print(bst);
    }

    @Test
    public void test0() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.root = new Node<>(7);
        bt.root.left = new Node<>(4);
        bt.root.right = new Node<>(9);
        bt.root.left.left = new Node<>(2);
        bt.root.left.right = new Node<>(5);
        bt.root.right.left = new Node<>(8);
        bt.root.right.right = new Node<>(11);
        bt.root.left.left.left = new Node<>(1);
        bt.root.left.left.right = new Node<>(3);
        bt.root.right.right.left = new Node<>(10);
        bt.root.right.right.right = new Node<>(12);

//        bt.preOrderTraversal(root);
//        bt.preOrderTraversal1(root);
//        bt.inOrderTraversal(root);
//        bt.inOrderTraversal1(root);
//        bt.postOrderTraversal(root);
//        bt.postOrderTraversal1(root);
//        bt.levelOrderTraversal(root);

//        BinaryTree.Visitor<Integer> visitor = new BinaryTree.Visitor<>() {
//            @Override
//            public boolean visit(Integer element) {
//                return false;
//            }
//        };
//
//        bt.preOrderTraversal(root, visitor);

//        BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new PersonComparator());

//        System.out.println(bt.height());
        System.out.println(bt.isCBT());
    }
}
