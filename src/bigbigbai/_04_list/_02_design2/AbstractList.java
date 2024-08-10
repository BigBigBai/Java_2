package bigbigbai._04_list._02_design2;

public abstract class AbstractList<E> implements List<E> {
    protected int size;

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

    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) outOfBounds(index);
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) outOfBounds(index);
    }

    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

}
