package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {
    MyStack<Integer> stackOfInts = MyStack.create();
    MyStack<Double> stackOfDoubles = MyStack.create();
    MyStack<String> stackOfStrings = MyStack.create();
    MyStack<Character> stackOfChars = MyStack.create();

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
    void testPopFromEmptyQueue(){
        assertThrows(IllegalArgumentException.class, () -> stackOfInts.pop());
    }

    @Test
    void testPushAndPop(){
        stackOfDoubles.push(2.5);
        stackOfDoubles.push(4.2);
        stackOfDoubles.push(5.1);
        double tmp = stackOfDoubles.pop();
        assertEquals(5.1, tmp);
        tmp = stackOfDoubles.pop();
        assertEquals(4.2, tmp);
        stackOfDoubles.push(42.24);
        tmp = stackOfDoubles.pop();
        assertEquals(42.24, tmp);
        tmp = stackOfDoubles.pop();
        assertEquals(2.5, tmp);
    }

    @Test
    void testNumberOfElements(){
        stackOfStrings.push("the first to be added in stack");
        stackOfStrings.push("the second to be added in stack");
        stackOfStrings.push("the third to be added in stack");
        stackOfStrings.push("the fourth to be added in stack");
        assertEquals(4, stackOfStrings.numOfElems());
        stackOfStrings.pop();
        stackOfStrings.push("the fifth to be added in stack");
        stackOfStrings.push("6th to be added in stack");
        stackOfStrings.push("7th to be added in stack");
        assertEquals(6, stackOfStrings.numOfElems());
        stackOfStrings.pop();
        stackOfStrings.pop();
        assertEquals(4, stackOfStrings.numOfElems());
    }

    @Test
    void testPeekOnEmptyStack(){
        assertThrows(IllegalArgumentException.class, () -> stackOfInts.peek());
    }

    @Test
    void testPeekOfStack(){
        stackOfChars.push('1');
        stackOfChars.push('6');
        stackOfChars.push('m');
        stackOfChars.push('9');
        assertEquals('9',stackOfChars.peek());
        stackOfChars.pop();
        assertEquals('m', stackOfChars.peek());
        stackOfChars.pop();
        assertEquals('6', stackOfChars.peek());
        stackOfChars.pop();
        assertEquals('1', stackOfChars.peek());
    }
}