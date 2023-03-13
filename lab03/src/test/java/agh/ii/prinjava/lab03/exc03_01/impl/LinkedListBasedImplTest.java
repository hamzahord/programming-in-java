package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListBasedImplTest {

    // Create an empty queue
    private final QueueOfInts queueOfInts = QueueOfIntsFtry.create(QueueOfIntsFtry.Impln.L_LIST_B);

    private final QueueOfInts queueOfInts2 = QueueOfIntsFtry.create(QueueOfIntsFtry.Impln.L_LIST_B);

    private final QueueOfInts queueOfInts3 = QueueOfIntsFtry.create(QueueOfIntsFtry.Impln.L_LIST_B);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * testing if a new queue is empty
     */
    @Test
    void newQueueIsEmpty() {
        assertTrue(queueOfInts.isEmpty());
    }

    /**
     * @throws Exception for handling an empty queue
     * testing enqueue and dequeue fonctions
     */
    @Test
    void testingEnqueueAndDequeue() throws Exception {
        queueOfInts2.enqueue(5);
        int tmp = queueOfInts2.dequeue();
        assertEquals(5,tmp);
        queueOfInts2.enqueue(4);
        queueOfInts2.enqueue(9);
        queueOfInts2.enqueue(7);
        tmp = queueOfInts2.dequeue();
        assertEquals(4,tmp);
        tmp = queueOfInts2.dequeue();
        assertEquals(9,tmp);
        tmp = queueOfInts2.dequeue();
        assertEquals(7, tmp);
    }

    /**
     * testing if the exception handling dequeue empty queue
     */
    @Test
    void DeQueueEmptyQueue() {
        assertThrows(Exception.class, queueOfInts::dequeue);
    }


    /**
     * @throws Exception handling an empty queue
     * testing the number of elements in a queue
     */
    @Test
    void testNumOfelementsInQueue() throws Exception {
        queueOfInts3.enqueue(5);
        queueOfInts3.dequeue();
        queueOfInts3.enqueue(6);
        assertEquals(1, queueOfInts3.numOfElems());
        queueOfInts3.enqueue(8);
        assertEquals(2,queueOfInts3.numOfElems());
        queueOfInts3.enqueue(42);
        queueOfInts3.enqueue(56);
        queueOfInts3.enqueue(0);
        queueOfInts3.enqueue(69);
        assertEquals(6,queueOfInts3.numOfElems());
    }

    /**
     * testing empty queue for peek
     */
    @Test
     void PeekEmptyQueue() {
        assertThrows(Exception.class, queueOfInts::peek);
    }


}
