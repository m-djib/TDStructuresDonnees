package container;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenPriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private int capacity;
    private final Comparator<E> cmp;
    private E[] tab;
    private int size;

    public GenPriorityQueue(int capacity, Comparator<E> comparator) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be a positive integer");
        }
        this.capacity = capacity;
        this.cmp = comparator;
        this.tab = (E[])(new Object[capacity]);
    }

    public void resize(int newSize) {
        int oldSize = this.capacity;
        if (oldSize > this.size) {
            throw new IllegalArgumentException("You can't resize to a smaller queue");
        }
        Object[] tmpTab = new Object[newSize];
        if (oldSize >= 0) {
            System.arraycopy(this.tab, 0, tmpTab, 0, oldSize);
        }
        this.capacity = newSize;
        this.tab = (E[])(tmpTab);
    }

    @Override
    public boolean insertElement(E e) {
        if (this.size >= this.capacity) {
            this.resize(2*this.capacity);
        }
        this.tab[this.size] = e;
        this.ascend(this.size);
        this.size += 1;
        return true;
    }

    private void ascend(int toAsc) {
        if (toAsc == 0){
            return;
        }

        E act = this.tab[toAsc];
        int k = (toAsc-1)/2;

        if (this.compare(this.tab[k],act) > 0) {
            this.tab[toAsc] = this.tab[k];
            this.tab[k] = act;
            this.ascend(k);
        }
    }

    private int compare(E a, E b) {
        return cmp.compare(a,b);
    }

    @Override
    public E element() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("File vide");
        }
        return this.tab[0];
    }

    @Override
    public E popElement() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("File vide");
        } else {
            E tempVal = this.tab[0];
            this.size -= 1;
            this.tab[0] = this.tab[this.size];
            this.tab[this.size] = null;
            this.descend(0);
            return tempVal;
        }
    }

    private void descend(int pos) {
        E act = this.tab[pos];

        if (2 * pos + 1 >= this.size) {
            return;
        } else if (2 * pos + 2 >= this.size) {
            E fg = this.tab[2 * pos + 1];
            if (this.compare(fg,act) >0) {
                this.tab[pos] = fg;
                this.tab[2 * pos + 1] = act;
            }
            return;
        }

        E fg = this.tab[2 * pos + 1];
        E fd = this.tab[2 * pos + 2];

        if (this.compare(fg,act) >0 || this.compare(fd,act) >0) {
            if (this.compare(fg,fd) >0) {
                this.tab[pos] = fg;
                this.tab[2 * pos + 1] = act;
                this.descend(2 * pos + 1);
            } else {
                this.tab[pos] = fd;
                this.tab[2 * pos + 2] = act;
                this.descend(2 * pos + 2);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public @NotNull Iterator<E> iterator() {
        return null;
    }
}
