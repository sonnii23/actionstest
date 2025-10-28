package de.hs_el.streekmann.algodat.aufgabe1;

public interface List<E> extends Iterable<E>{
    boolean add(E element);
    E get(int index);
    int size();

    E remove(int index);
    boolean remove(Object o);
    int indexOf(Object o);

    int getCount();
    int iteratorCount();
}
