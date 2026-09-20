package container;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class GenPriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private int capacity;
    private E[] tab;
    private int size;

    public GenPriorityQueue(int capacity){
        this.capacity = capacity;
    }

    @Override
    public boolean insertElement(E e) {
        return false;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E popElement() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public @NotNull Iterator<E> iterator() {
        return null;
    }
}
