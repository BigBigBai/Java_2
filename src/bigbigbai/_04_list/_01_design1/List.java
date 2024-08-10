package bigbigbai._04_list._01_design1;

public class List<E> {
    private int size;
    private static final int ELEMENT_NOT_FOUND = -1;

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




    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E element) {
        add(size, element);
    }

    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }
}
