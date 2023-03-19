package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyQueueDLLBImpl;

public interface MyQueue<E> {
    /**
     * the function will be implemented in MyQueueDLLBImpl Class and adds an element in Queue.
     * @param x is the element to be put in a Queue.
     */
    void enqueue(E x);

    /**
     * the function that will be implemented in MyQueueDLLBImpl Class and removes an element from a Queue.
     * @return the element to be removed from a Queue.
     */
    E dequeue();

    /**
     * the function that tests if a Queue is Empty.
     * @return True if the Queue is empty, False otherwise.
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * the function will be implemented in MyQueueDLLBImpl Class and gives the number of elements in a Queue.
     * @return the number of elements in a Queue.
     */
    int numOfElems();

    /**
     * the function that will be implemented in MyQueueDLLBImpl Class and shows the element that will be removed from the Queue.
     * @return the element to be removed next from the Queue.
     */
    E peek();

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
