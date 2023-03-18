package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;

public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * the goal of the function is to pop an element from a stack.
     * @return the element that has been popped from the stack.
     * This function removes the first element of type E from a DLinkedList.
     */
    @Override
    public E pop() {
        if (elems.head == null)
            throw new IllegalArgumentException();
        E res = elems.head.elem;
        elems.removeFirst();
        return res;
    }

    /**
     * The goal of the function is to enqueue an element in a queue.
     * @param x is element to be added in queue.
     * This function add an element of type E as the first element of a DLinkedList.
     */
    @Override
    public void push(E x) {
        elems.addFirst(x);
    }

    /**
     * The goal of the function is to return the number of elements in a stack.
     * @return the size of the stack.
     * this function returns the size of the DLinkedList.
     */
    @Override
    public int numOfElems()
    {
        return elems.size;
    }

    /**
     *the goal of the function is to get the element that is about to be popped from the stack.
     * @return the element that will be popped next from the stack.
     * this function returns the first element of type E of a DLinkedList
     */
    @Override
    public E peek() {
        if (elems.head == null)
            throw new IllegalArgumentException();
        return elems.head.elem;
    }
}
