package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * The goal of the function is to enqueue an element in a queue.
     * @param x is element to be added in queue
     * This function add an element of type E as the first element of a DLinkedList.
     */
    @Override
    public void enqueue(E x) {
        elems.addFirst(x);
    }

    /**
     * the goal of the function is to dequeue an element from a queue.
     * @return the element that has been popped
     * This function removes the last element of type E from a DLinkedList
     */
    @Override
    public E dequeue() {
        E res = elems.tail.elem;
        elems.removeLast();
        return res;
    }

    /**
     * The goal of the function is to return the number of elements in a queue.
     * @return the size of the queue
     * this function returns the size of the DLinkedList.
     */
    @Override
    public int numOfElems() {
        return elems.size;
    }

    /**
     *the goal of the function is to get the element that is about to be popped.
     * @return the element that will be popped next from the queue.
     * this function returns the last element of type E of a DLinkedList
     */
    @Override
    public E peek() {
        return this.elems.tail.elem;
    }
}
