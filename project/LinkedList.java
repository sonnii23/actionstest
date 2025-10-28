package de.hs_el.streekmann.algodat.aufgabe1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> List<E> {
    private class Node {
        private final E element;
        Node successor;

        Node(E element) {
            this.element = element;
            this.successor = null;
        }
    }

    Node firstNode;
    Node lastNode;
    int numberOfElements;
    int getCount = 0;
    int iteratorCount = 0;

    public LinkedList() {
        firstNode = new Node(null);
        lastNode = firstNode;
        numberOfElements = 0;
    }

    @Override
    public boolean add(E element) {
        Node addedNode = new Node(element);
        lastNode.successor = addedNode;
        lastNode = addedNode;
        numberOfElements++;
        return true;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= numberOfElements) {
            throw new IndexOutOfBoundsException();
        }
        Node nodeAtCurrentIndex = firstNode.successor;
        for (int currentIndex = 0; currentIndex < index; currentIndex++) {
            nodeAtCurrentIndex = nodeAtCurrentIndex.successor;
            getCount++;
        }
        return nodeAtCurrentIndex.element;
    }

    @Override
    public int getCount() {
        return getCount;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node nextNode = firstNode.successor;
            Node currentNode;

            @Override
            public boolean hasNext() {
                return nextNode != null;
            }

            @Override
            public E next() {
                if (nextNode == null) {
                    throw new NoSuchElementException();
                }
                currentNode = nextNode;
                nextNode = nextNode.successor;
                iteratorCount++;
                return currentNode.element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public int iteratorCount() {
        return iteratorCount;
    }

    @Override
    public E remove(int index) {
        // is index valid?
        if (index < 0 || index >= numberOfElements) {
            throw new IndexOutOfBoundsException();
        }
        //create Nodes
        Node nodeBeforeRemovedNode = firstNode;        

        Node nodeAtCurrentIndex = firstNode.successor;
        //for-loop to find the node before the one to be removed
        for (int i = 0; i < index; i++) {
            nodeBeforeRemovedNode = nodeAtCurrentIndex;
            nodeAtCurrentIndex = nodeAtCurrentIndex.successor;
            }
        //if condition for lastNode
        if (nodeAtCurrentIndex.equals(lastNode)) {
            //setting new lastNode pointer
            lastNode = nodeBeforeRemovedNode;
            }
        //remove the node by skipping it in the chain
        nodeBeforeRemovedNode.successor = nodeAtCurrentIndex.successor;
        //decrease number of elements
        numberOfElements--;
        //return removed element
        return nodeAtCurrentIndex.element;
    }


    @Override
    public boolean remove(Object o) {
        //initialize nodeAtIndex with firstNode
        Node nodeAtIndex = firstNode;
        //to keep track of the node before the one to be removed
        Node nodeBeforeRemovedNode;
        //iterate through the list and check each element
        for (int i = 0; i < numberOfElements; i++) {
            //move to the next node
            nodeBeforeRemovedNode = nodeAtIndex;
            nodeAtIndex = nodeAtIndex.successor;
            //if the element is found return the index
            if (nodeAtIndex.element.equals(o)) {
                //remove the node by skipping it in the chain
                nodeBeforeRemovedNode.successor = nodeAtIndex.successor;
                if (nodeAtIndex.equals(lastNode)){
                    lastNode = nodeBeforeRemovedNode;
                }
                //decrease number of elements
                numberOfElements--;
                //return true
                return true;
            }
            
        }
        //if not found return false
        return false;
   
    }

    @Override
    public int indexOf(Object o) {
        //initialize nodeAtIndex with firstNode
        Node nodeAtIndex = firstNode;
        //iterate through the list and check each element
        for (int i = 0; i < numberOfElements; i++) {
            //move to the next node
            nodeAtIndex = nodeAtIndex.successor;
            //if the element is found return the index
            if (nodeAtIndex.element.equals(o)) {
                return i;
            }
        }
        //if not found return -1
        return -1;
    }
}
