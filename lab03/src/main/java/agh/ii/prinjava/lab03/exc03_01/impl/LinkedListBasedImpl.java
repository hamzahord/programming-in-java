package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;

public class LinkedListBasedImpl implements QueueOfInts {

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

    @Override
    public int numOfElems() {
        return this.numOfElems;
    }

    @Override
    public int peek() {
        throw new IllegalStateException("To be implemented");
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
