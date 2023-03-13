package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListBasedImplTest {

    // Create an empty queue
    private final QueueOfInts queueOfInts = QueueOfIntsFtry.create(QueueOfIntsFtry.Impln.L_LIST_B);

    private QueueOfInts queueOfInts2 = QueueOfIntsFtry.create(QueueOfIntsFtry.Impln.L_LIST_B);

    private QueueOfInts queueOfInts3 = QueueOfIntsFtry.create(QueueOfIntsFtry.Impln.L_LIST_B);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newQueueIsEmpty() {
        assertTrue(queueOfInts.isEmpty());
    }

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

    @Test
    void DeQueueEmptyQueue() {
        assertThrows(Exception.class, () -> queueOfInts.dequeue());
    }


    @Test
    void testNumOfelementsInQueue() throws Exception {
        queueOfInts3.enqueue(5);
        int tmp = queueOfInts3.dequeue();
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


}
