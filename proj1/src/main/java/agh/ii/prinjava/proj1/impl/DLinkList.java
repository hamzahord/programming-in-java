package agh.ii.prinjava.proj1.impl;

public class DLinkList<E> {
    /**
     * Inner Class Node
     */
    public static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;

        /**
         * Constructor
         */
        public Node(T elem) {
            this.elem = elem;
        }

        public Node(T elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    Node<E> head; //head of the list
    Node<E> tail; //tail of the list
    public int size = 0;

    /**
     * Methods of the class
     */

    //add a node in the beginning of the list
    public void addFirst(E x) {
        Node<E> n_node = new Node<>(x);
        n_node.next = null;
        //if list is empty
        if (this.head == null) {
            this.head = n_node;
            this.tail = this.head;
        } else {
            Node<E> temp = this.head;//creating temporary node to keep values of head
            this.head = n_node;
            temp.prev = n_node;
            n_node.next = temp;
            if (this.head.next != null && this.head.next.next == null) {
                this.tail = this.head.next;
            }
        }
        this.size++;
    }

    //add a node at the end of the list
    public void addLast(E x) {
        Node<E> n_node = new Node<>(x);
        n_node.next = null;
        //if list is empty
        if (this.head == null) {
            this.head = n_node;
            this.tail = this.head;
        } else {
            Node<E> last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = n_node;
            this.tail = n_node;
        }
        this.size++;
    }

    //remove first node of the list
    public void removeFirst() {
        //if list empty
        if (this.head == null) {
            throw new IllegalArgumentException();
        } else {
            //if there's only one value in the list
            if (this.head.next == null) {
                this.head = null;//deleting only node
                this.tail = null;
            } else {
                this.head = this.head.next;
                this.head.prev = null;
            }
        }
        this.size--;
    }

    //remove last node of the list
    public void removeLast() {
        //if list is empty
        if (this.head == null ) {
            throw new IllegalArgumentException();
        }
        if (this.head.next == null)
            this.head = null;
        else {
            Node<E> temp = this.head;
            //running through the list until it's before final node
            while (temp.next.next != null) {
                temp = temp.next;
            }
            this.tail = temp;
            temp.next = null;//deleting last node
        }
        this.size--;
    }

    /**
     * Overriding class Object method toString to display Linked List as such :
     * Example : "1"
     * Example 2 : "1-->2-->3-->6"
     * Example 3 : "List is empty"
     */

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        //if list is empty
        if (this.head == null) {
            return "List is empty";
        } else {
            res.append(this.head.elem);//adding the head of the list in the stirng
            Node<E> temp = this.head;
            //running through every values of the list
            while (temp.next != null) {
                res.append("-->");
                res.append(temp.next.elem);//concatenating string with current value
                temp = temp.next;
            }
            return res.toString();
        }
    }

}