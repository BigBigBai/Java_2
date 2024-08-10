package bigbigbai._04_list._02_design2.doubly;

import bigbigbai._04_list._02_design2.AbstractList;

public class LinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;


    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private Node<E> node(int index) {
        Node<E> node;

        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++) node = node.next;
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) node = node.prev;
        }

        return node;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == size) {
            // tail/first node
            Node<E> oldLast = last;
            Node<E> newLast = new Node<>(element, oldLast, null);

            last = newLast;
            if (size == 0) first = newLast;
            else oldLast.next = newLast;
        } else {
            // current/head
            Node<E> nextNode = node(index);
            Node<E> prevNode = nextNode.prev;
            Node<E> newNode = new Node<>(element, prevNode, nextNode);

            nextNode.prev = newNode;
            if (index == 0) first = newNode;
            else prevNode.next = newNode;
        }

        size++;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, Object element) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object element) {
        return 0;
    }

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;


        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
}
