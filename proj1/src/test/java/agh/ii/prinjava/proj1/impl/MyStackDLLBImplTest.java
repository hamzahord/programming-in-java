package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {
    /**
     * Stacks that will be used for testing.
     */
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

    /**
     * testing empty Stack.
     */
    @Test
    void testEmptyStack(){
        assertTrue(stackOfInts.isEmpty());
    }

    /**
     * testing handling Exception when trying to pop from empty Stack.
     */
    @Test
    void testPopFromEmptyStack(){
        assertThrows(IllegalArgumentException.class, () -> stackOfInts.pop());
    }

    /**
     * testing pushing and popping from a Stack.
     */
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

    /**
     * testing number of elements in a Stack.
     */
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

    /**
     * testing handling Exception when peeking an empty Stack.
     */
    @Test
    void testPeekOnEmptyStack(){
        assertThrows(IllegalArgumentException.class, () -> stackOfInts.peek());
    }

    /**
     * testing peeking a Stack.
     */
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