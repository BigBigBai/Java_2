package bigbigbai._07_tree;

import bigbigbai._07_tree.BinaryTree.Node;

public class Main {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(7);
        root.left = new Node<>(4);
        root.right = new Node<>(9);
        root.left.left = new Node<>(2);
        root.left.right = new Node<>(5);
        root.left.left.left = new Node<>(1);
        root.left.left.right = new Node<>(3);

        root.right.left = new Node<>(8);
        root.right.right = new Node<>(11);
        root.right.right.left = new Node<>(10);
        root.right.right.right = new Node<>(12);

        BinaryTree<Integer> bt = new BinaryTree<>();
//        bt.preOrderTraversal(root);
//        bt.preOrderTraversal1(root);
//        bt.inOrderTraversal(root);
//        bt.inOrderTraversal1(root);
//        bt.postOrderTraversal(root);
//        bt.postOrderTraversal1(root);
//        bt.levelOrderTraversal(root);

        BinaryTree.Visitor<Integer> visitor = new BinaryTree.Visitor<>() {

            @Override
            public boolean visit(Integer element) {
                return false;
            }
        };

        bt.preOrderTraversal(root, visitor);


    }
}
