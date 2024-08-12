package bigbigbai._04_list._02_design2.doubly;

import bigbigbai._04_list._02_design2.AbstractList;
import bigbigbai._04_list._02_design2.singly.SingleLinkedList;

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
        rangeCheck(index);
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> oldNode = node(index);
        E oldVal = oldNode.element;
        oldNode.element = element;
        return oldVal;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        // current/only one node
        Node<E> node = node(index);
        Node<E> prevNode = node.prev;
        Node<E> nextNode = node.next;

        if (index == 0) first = nextNode;// head
        else prevNode.next = nextNode;

        if (index == size - 1) last = prevNode;// tail
        else nextNode.prev = prevNode;

        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }

        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element.equals(element)) return i;
                node = node.next;
            }

        }
        return ELEMENT_NOT_FOUND;
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
