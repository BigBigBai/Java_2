package bigbigbai._04_list._01_design1;

public class SingleLinkedList<E> extends List<E> {
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

    }

    public void add(int index, E element) {

    }

    public E get(int index) {
        return null;
    }

    public E set(int index, E element) {
        return null;
    }

    public E remove(int index) {
        return null;
    }

    public int indexOf(E element) {
        return 0;
    }
}
