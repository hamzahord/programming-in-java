package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {
    private final MyQueue<Integer> queueOfInts = MyQueue.create();
    private final MyQueue<String> queueofString = MyQueue.create();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testEmptyQueue(){
        assertTrue(queueOfInts.isEmpty());
    }

    @Test
    void testEnqueue(){
        queueofString.enqueue("first to be added");
        queueofString.enqueue("second in queue");
        assertEquals("first to be added", queueofString.peek());
        queueofString.enqueue("third in queue");
        assertEquals(3, queueofString.numOfElems());
    }


}