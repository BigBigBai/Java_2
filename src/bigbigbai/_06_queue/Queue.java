package bigbigbai._06_queue;

import bigbigbai._06_queue.doubly.LinkedList;

public class Queue<E> {
    private LinkedList<E> list = new LinkedList<E>();

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enQueue(E element) {
        list.add(element);
    }

    public E deQueue() {
        return list.remove(0);
    }

    public E front() {
        return list.get(0);
    }
}
