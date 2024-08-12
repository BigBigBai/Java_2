package bigbigbai._04_list._02_design2.singly;

import bigbigbai._04_list._02_design2.AbstractList;

public class SingleCircularLinkedList<E> extends AbstractList<E> {
    Node<E> first;

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        size++;

        // head/first node
        if (index == 0) {
            Node<E> newFirst = new Node<>(element, first);
            first = newFirst;

            Node<E> last;
            if (size == 0) last = newFirst;
            else last = node(size - 1);
            last.next = newFirst;
        } else {
            // current/tail
            Node<E> prevNode = node(index - 1);
            prevNode.next = new Node<>(element, prevNode.next);
        }

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
        E oldElement = oldNode.element;
        oldNode.element = element;
        return oldElement;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        size--;
        Node<E> removed = first;

        // head/only one node
        if (index == 0) {
            if (size == 0) {
                first = null;
            } else {
                first = first.next;
                Node<E> last = node(size - 1);
                last.next = first;
            }

        } else {
            // current/tail
            Node<E> prevNode = node(index - 1);
            removed = prevNode.next;
            prevNode.next = removed.next;
        }

        return removed.element;
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

    private Node<E> node(int index) {
//        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
