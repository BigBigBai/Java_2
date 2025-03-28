package bigbigbai._06_queue;

import bigbigbai._06_queue.doubly.LinkedList;

public class Deque<E> {
    private LinkedList<E> list = new LinkedList<>();

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enQueueRear(E element) {
        list.add(element);
    }

    public E deQueueFront() {
        return list.remove(0);
    }

    public void enQueueFront(E element) {
        list.add(0, element);
    }

    public E deQueueRear() {
        return list.remove(list.size() - 1);
    }

    public E front() { return list.get(0); }

    public E rear() { return list.get(list.size()-1); }
}
