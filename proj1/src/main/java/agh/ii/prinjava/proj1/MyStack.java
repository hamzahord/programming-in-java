package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyStackDLLBImpl;

public interface MyStack<E> {
    /**
     * the function that will be implemented in MyStackDLLBImpl Class and removes an element from a Stack.
     * @return the element to be removed from a Stack.
     */
    E pop();

    /**
     * the function will be implemented in MyStackDLLBImpl Class and pushs an element in a Stack.
     * @param x is the element to be pushed in a Stack.
     */
    void push(E x);

    /**
     * the function that tests if a Stack is Empty.
     * @return True if the Stack is empty, False otherwise.
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * the function will be implemented in MyStackDLLBImpl Class and gives the number of elements in a Stack.
     * @return the number of elements in a Stack.
     */
    int numOfElems();

    /**
     * the function that will be implemented in MyStackDLLBImpl Class and shows the element that will be removed from the Stack.
     * @return the element to be removed next from the Stack.
     */
    E peek();

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}
