package container;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntFIFO implements Queue<Integer>{

    private int capacity;
    private Integer[] tab;
    private int begin;
    private int end;

    public IntFIFO(int capacity){
        this.capacity = capacity;
        this.begin = 0;
        this.end = 0;
        this.tab = new Integer[capacity];
    }

    @Override
    public boolean insertElement(Integer integer) {
        this.tab[end] = integer;

        if ((this.end+1)%this.capacity == this.begin){
            Integer[] tempTab = new Integer[this.capacity*2];
            for(int i =0; i<this.capacity;i++){
                tempTab[i] = this.tab[(this.begin+i)%this.capacity];
            }
            this.capacity *= 2;
            this.tab=tempTab;
        }

        this.end = (this.end+1)%this.capacity;
        return true;
    }

    @Override
    public Integer element() {
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }
        else {
            return this.tab[begin];
        }
    }

    @Override
    public Integer popElement() {
        if (this.isEmpty()){
            throw new NoSuchElementException();
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
    public Iterator<Integer> iterator() {
        return null;
    }
}

