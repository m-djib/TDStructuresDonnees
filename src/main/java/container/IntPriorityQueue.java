package container;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntPriorityQueue implements Queue<Integer> {

    private int capacity;
    private Integer[] tab;
    private int size;

    public IntPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.tab = new Integer[capacity];
        this.size = 0;
    }

    @Override
    public boolean insertElement(Integer integer) {
        return false;
    }

    @Override
    public Integer element() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return this.tab[0];
        }
    }

    @Override
    public Integer popElement() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Integer tempVal = this.tab[0];
            this.size -= 1;
            this.tab[0] = this.tab[this.size];
            this.descend(0);
            return tempVal;
        }
    }

    private void descend(int pos) {
        Integer act = this.tab[pos];

        if (2 * pos + 1 >= this.size) {
            return;
        } else if (2 * pos + 2 >= this.size) {
            Integer fg = this.tab[2 * pos + 1];
            if (fg > act) {
                this.tab[pos] = fg;
                this.tab[2 * pos + 1] = act;
            }
        }

        Integer fg = this.tab[2 * pos + 1];
        Integer fd = this.tab[2 * pos + 2];

        if (fg > act || fd > act) {
            if (fg > fd) {
                this.tab[pos] = fg;
                this.tab[2 * pos + 1] = act;
                descend(2 * pos + 1);
            } else {
                this.tab[pos] = fd;
                this.tab[2 * pos + 2] = act;
                descend(2 * pos + 2);
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
    public Iterator<Integer> iterator() {
        return null;
    }
}
