package container;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements a resizable Integer queue structure.
 */

public class IntFIFO implements Queue<Integer>, Iterable<Integer>{

    private int capacity;
    private Integer[] tab;
    private int begin;
    private int end;

    /** Creates an empty queue.
     * @param capacity a positive integer giving the base capacity of the queue
     * @throws IllegalArgumentException if the given capacity is negative
     */

    public IntFIFO(int capacity){
        if (capacity < 0) {
            throw new IllegalArgumentException("Negative capacity not allowed");
        } else {
            this.capacity = capacity;
            this.begin = 0;
            this.end = 0;
            this.tab = new Integer[capacity];
        }
    }

    @Override
    public boolean insertElement(Integer integer) {
        this.tab[end] = integer;
        this.end = this.end+1;

        if (this.size()==this.capacity){
            this.resize(this.capacity*2);
        }
        this.end%=this.capacity;
        return true;
    }

    /**
     * Changes the capacity of the queue
     * @param newSize the size to which the queue capacity should be changed
     * @throws IllegalArgumentException if the new size is lower than the current one
     */
    public void resize(int newSize) {
        int oldSize = this.size();
        if (newSize < oldSize) {
            throw new IllegalArgumentException("The queue can't be resized to a lower value than its current size");
        } else {
            Integer[] tempTab = new Integer[newSize];
            for(int i =0; i<this.capacity;i++){
                tempTab[i] = this.tab[(this.begin+i)%this.capacity];
            }
            this.begin=0;
            this.end = oldSize;
            this.capacity = newSize;
            this.tab=tempTab;
        }
    }

    @Override
    public Integer element() {
        if (this.isEmpty()){
            throw new NoSuchElementException("Empty queue");
        }
        else {
            return this.tab[begin];
        }
    }

    @Override
    public Integer popElement() {
        if (this.isEmpty()){
            throw new NoSuchElementException("Empty queue");
        }
        else {
            Integer temp = this.tab[begin];
            this.tab[this.begin] = null;
            this.begin = (this.begin + 1)%this.capacity;
            return temp;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.begin == this.end;
    }

    @Override
    public int size() {
        if (this.end >= this.begin){
            return this.end-this.begin;
        } else {
            return this.capacity - this.begin + this.end;
        }
    }

    @Override
    @NotNull
    public Iterator<Integer> iterator() {
        return new IntFIFOIterator();
    }

    private class IntFIFOIterator implements Iterator<Integer> {

        private int counter;

        private IntFIFOIterator() {
            counter = IntFIFO.this.begin;
        }

        @Override
        public boolean hasNext() {
            return counter != IntFIFO.this.end;
        }

        @Override
        public Integer next() {
            if (!(this.hasNext())) {
                throw new NoSuchElementException();
            }
            Integer val = IntFIFO.this.tab[counter];
            counter+=1;
            counter%=IntFIFO.this.capacity;
            return val;
        }
    }
}

