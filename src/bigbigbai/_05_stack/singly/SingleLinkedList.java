package bigbigbai._05_stack.singly;

import bigbigbai._05_stack.AbstractList;

public class SingleLinkedList<E> extends AbstractList<E> {
    Node<E> first;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    public void clear() {
        first = null;
        size = 0;
    }

    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void add(int index, E element) {
        rangeCheckForAdd(index);
        // head/first node
        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            // current/tail
            Node<E> prevNode = node(index - 1);
            prevNode.next = new Node<>(element, prevNode.next);
        }

        size++;
    }

    public E get(int index) {
        rangeCheck(index);
        return node(index).element;
    }

    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> oldNode = node(index);
        E oldElement = oldNode.element;
        oldNode.element = element;
        return oldElement;
    }

    public E remove(int index) {
        rangeCheck(index);
        Node<E> removed = first;

        // head/only one node
        if (index == 0) {
            first = first.next;
        } else {
            // current/tail
            Node<E> prevNode = node(index - 1);
            removed = prevNode.next;
            prevNode.next = removed.next;
        }

        size--;
        return removed.element;
    }

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

    // size=3, elements=[a, b, c]
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append(", elements=[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) sb.append(", ");
            sb.append(node.element);
            node = node.next;
        }
        sb.append("]");

        return sb.toString();
    }

}
