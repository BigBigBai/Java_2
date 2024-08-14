package bigbigbai._05_stack;

public interface List<E> {

    public static final int ELEMENT_NOT_FOUND = -1;

    public int size();

    public boolean isEmpty();

    public void clear();

    public void add(E element);

    public void add(int index, E element);

    public E get(int index);

    public E set(int index, E element);

    public E remove(int index);

    public int indexOf(E element);

    public boolean contains(E element);
}
