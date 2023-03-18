package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {
    MyStack<Integer> stackOfInts = MyStack.create();
    MyStack<Double> stackOfDouble = MyStack.create();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testEmptyQueue(){
        assertTrue(stackOfInts.isEmpty());
    }

    @Test
    void testEnqueue(){
        stackOfDouble.push(2.5);
        stackOfDouble.push(4.2);
        assertEquals(4.2, stackOfDouble.peek());
        stackOfDouble.push(52.6);
        assertEquals(3, stackOfDouble.numOfElems());
    }
}