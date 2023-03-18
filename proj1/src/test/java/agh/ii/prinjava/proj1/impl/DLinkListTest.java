package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLinkListTest {
    //creating empty Doubled Linked List that we will use in every test
    DLinkList<Integer> dLinkList = new DLinkList<>();


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testRemoveFromEmptyDLinkedList(){
        assertThrows(IllegalArgumentException.class, () -> dLinkList.removeFirst());
        assertThrows(IllegalArgumentException.class, () -> dLinkList.removeLast());
    }

    @Test
    public void addFirstTest() {
        assertNull(dLinkList.head);//checking if list is null
        dLinkList.addFirst(1);
        assertEquals(dLinkList.head.elem, 1);//checking that value of head = 1
        assertEquals(dLinkList.tail.elem, 1);//checking tail is also 1
        assertNotNull(dLinkList.head);
    }

    @Test
    public void addFirstTest2(){
        dLinkList.addFirst(1);
        dLinkList.addFirst(2);
        dLinkList.addFirst(3);
        assertEquals(dLinkList.head.elem, 3);//checking that first value of list is 3
        assertEquals(dLinkList.tail.elem, 1);//checking last value is 1
    }

    @Test
    public void addLastTest() {
        dLinkList.addFirst(2);
        dLinkList.addFirst(8);
        dLinkList.addLast(6);
        assertEquals(dLinkList.tail.elem, 6);//checking that last value is 6
    }

    @Test
    public void removeFirstTest(){
        dLinkList.addFirst(2);
        dLinkList.addFirst(3);//list is "3-->2"
        dLinkList.removeFirst();
        assertEquals(dLinkList.head.elem, 2);//checking that first value is 2
        dLinkList.removeFirst();
        assertNull(dLinkList.head);//checking that list is empty
        assertNull(dLinkList.tail);
    }

    @Test
    public void removeLastTest(){
        dLinkList.addFirst(5);
        dLinkList.addFirst(8);
        dLinkList.addLast(9);
        assertEquals(dLinkList.tail.elem, 9);//checking last value is 9
        dLinkList.removeLast();
        assertEquals(dLinkList.tail.elem, 5);//checking that there's no more a third value in the list
    }

    @Test
    public void toStringTest(){
        //checking that method toString() displays Doubled Linked List as expected
        assertEquals(dLinkList.toString(), "List is empty");
        dLinkList.addFirst(2);
        assertEquals(dLinkList.toString(), "2");
        dLinkList.addFirst(8);
        dLinkList.addLast(7);
        assertEquals(dLinkList.toString(), "8-->2-->7");
    }
}