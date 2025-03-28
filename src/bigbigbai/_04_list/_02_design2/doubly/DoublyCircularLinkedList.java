package bigbigbai._04_list._02_design2.doubly;

import bigbigbai._04_list._02_design2.AbstractList;

public class DoublyCircularLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;


    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == size) {
            // tail/first node
            Node<E> oldLast = last;
            Node<E> newLast = new Node<>(element, oldLast, first);

            last = newLast;
            if (size == 0) {
                first = newLast;
                first.next = first;
                first.prev = first;
            }
            else {
                oldLast.next = newLast;
                first.prev = newLast;
            }
        } else {
            // current/head
            Node<E> nextNode = node(index);
            Node<E> prevNode = nextNode.prev;
            Node<E> newNode = new Node<>(element, prevNode, nextNode);

            nextNode.prev = newNode;
            prevNode.next = newNode;
            if (index == 0) first = newNode;
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
        Node<E> node = node(index);

        // only one node
        if (size == 1) {
            first = null;
            last = null;
        } else {
            // current
            Node<E> prevNode = node.prev;
            Node<E> nextNode = node.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            if (index == 0) first = nextNode;// head
            if (index == size - 1) last = prevNode;// tail
        }

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
