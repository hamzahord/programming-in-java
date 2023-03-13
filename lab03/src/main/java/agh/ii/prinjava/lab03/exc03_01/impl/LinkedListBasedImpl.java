package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;

public class LinkedListBasedImpl implements QueueOfInts {

    /**
     * @param x the element to be added in the queue
     * the function add an element in a queue as first if empty queue
     * the function add an element in a queue as last otherwise
     */
    @Override
    public void enqueue(int x) {
        Node queue = new Node(x);
        if (this.last == null){
            this.first =  queue;
        }
        else {
            this.last.next = queue;
        }
        this.last = queue;
        this.numOfElems++;
    }

    /**
     * @return the popped element
     * @throws Exception handles the case when the queue is empty
     * the function pops the first element of a queue
     */
    @Override
    public int dequeue() throws Exception{
        if (this.first == null){
            throw new Exception("queue is empty");
        }
        int res = this.first.elem;
        this.first = this.first.next;
        this.numOfElems--;
        if (this.first == null)
            this.last = null;
        return res;
    }

    /**
     * @return the number of elements of a queue
     */
    @Override
    public int numOfElems() {
        return this.numOfElems;
    }

    /**
     * @return the element that is going to be popped
     * @throws Exception handles the case when a queue is empty
     */
    @Override
    public int peek() throws Exception {
        if (this.first == null)
            throw new Exception("Empty queue, nothing is going to be popped ");
        else
            return this.first.elem;
    }

    private static class Node {
        int elem;
        Node next;
        Node prev;

        public Node(int elem) {
            this.elem = elem;
        }

        public Node(int elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node first = null;
    private Node last = null;
    private int numOfElems = 0;
}
