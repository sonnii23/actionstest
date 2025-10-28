package de.hs_el.streekmann.algodat.aufgabe1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {

    private static final int MAXSIZE = 32;
    private int size;
    private final E[] elementArray;
    private int iteratorCountArr = 0;
    private int getCountArr = 0;

    public ArrayList() {
        this(MAXSIZE);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int numberOfElements) {
        size = 0;
        elementArray = (E[]) new Object[numberOfElements];
    }

    @Override
    public boolean add(E element) {
        if (size < elementArray.length) {
            elementArray[size] = element;
            size++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        getCountArr++;
        return elementArray[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int nextIndex = 0;
            int currentIndex;

            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public E next() {
                if (nextIndex >= size) {
                    throw new NoSuchElementException();
                }
                currentIndex = nextIndex;
                nextIndex++;
                iteratorCountArr++;
                return elementArray[currentIndex];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    public E remove(int index){
        return null;
    }
    public boolean remove(Object o){
        return false;
    }
    public int indexOf(Object o){
        return -1;
    }    
    public int getCount(){
        return getCountArr;
    }
    public int iteratorCount(){
        return iteratorCountArr;
    }

}
