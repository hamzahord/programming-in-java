package agh.ii.prinjava.proj1.impl;

public class DLinkList<E> {
    // ...
    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;
        Node(T elem){
            this.elem = elem;
            this.next = null;
            this.prev = null;
        }
    }

    public void addFirst(E x) {
        Node<E> n_node = new Node(x);
        n_node.next = null;
        //if list is empty
        if (this.head == null) {
            this.head = n_node;
        }
        else {
            n_node.next = this.head;
            this.head.prev = n_node;
        }
    }

    public void addLast(E x) {
        Node<E> n_node = new Node(x);
        n_node.next = null;
        //if list is empty
        if (this.head == null) {
            this.head = n_node;
        }
        else {
            Node last = this.head;
            while (last.next != null){
                last = last.next;
            }
            last.next = n_node;
        }
    }

    public E removeFirst(){
        //TODO
        throw new IllegalStateException("To be implemented");
    }

    public E removeLast(){
        //TODO
        throw new IllegalStateException("to be done");
    }

    public String toString() {
        //TODO
        throw new IllegalStateException("to be done with");
    }

    Node head; //head of the list
}
