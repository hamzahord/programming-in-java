package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {
    private final MyQueue<Integer> queueOfInts = MyQueue.create();
    private final MyQueue<String> queueofStrings = MyQueue.create();
    private final MyQueue<Double> queueOfDoubles = MyQueue.create();
    private final MyQueue<Character> queueOfChars = MyQueue.create();

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
    void testDequeueEmptyQueue(){
        assertThrows(IllegalArgumentException.class, queueOfInts::dequeue);
    }

    @Test
    void testEnqueueAndDequeue(){
        queueofStrings.enqueue("first to be added");
        queueofStrings.enqueue("second in queue");
        queueofStrings.enqueue("third in queue");
        String tmp = queueofStrings.dequeue();
        assertEquals("first to be added", tmp);
        tmp = queueofStrings.dequeue();
        assertEquals("second in queue", tmp);
        queueofStrings.enqueue("fourth to be added");
        tmp = queueofStrings.dequeue();
        assertEquals("third in queue", tmp);
        tmp = queueofStrings.dequeue();
        assertEquals("fourth to be added", tmp);
    }

    @Test
    void testNumberOfElements(){
        queueOfDoubles.enqueue(42.42);
        queueOfDoubles.enqueue(24.42);
        queueOfDoubles.enqueue(5.1);
        queueOfDoubles.enqueue(3.0);
        assertEquals(4, queueOfDoubles.numOfElems());
        queueOfDoubles.dequeue();
        queueOfDoubles.enqueue(7.3);
        queueOfDoubles.enqueue(4.4);
        assertEquals(5, queueOfDoubles.numOfElems());
        queueOfDoubles.dequeue();
        queueOfDoubles.dequeue();
        assertEquals(3, queueOfDoubles.numOfElems());
    }

    @Test
    void testPeekOnEmptyQueue(){
        assertThrows(IllegalArgumentException.class, queueOfInts::peek);
    }

    @Test
    void testPeekOfQueue(){
        queueOfChars.enqueue('1');
        queueOfChars.enqueue('6');
        queueOfChars.enqueue('m');
        queueOfChars.enqueue('9');
        assertEquals('1', queueOfChars.peek());
        queueOfChars.dequeue();
        assertEquals('6', queueOfChars.peek());
        queueOfChars.dequeue();
        assertEquals('m', queueOfChars.peek());
        queueOfChars.dequeue();
        assertEquals('9', queueOfChars.peek());
    }


}