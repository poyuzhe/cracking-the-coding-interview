package com.stmartin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by martinshen on 2017/10/3.
 * Spec:
 * 1. design a class that support Stack operations as well as a min() operation.
 * 2. the min() operation returns the current minimum element in the stack, or null if stack is null.
 * 3. push(), pop() and min() operations should all operate in O(1) time.
 */
public class StackMinSpec {
    StackMin<Integer> stackMin;

    @Before
    public void setUp() {
        stackMin = new StackMin<>();
    }

    @Test
    public void whenStackIsNullOrEmptyThenMinIsNull() {
        assertEquals(stackMin.min(), null);
    }

    @Test
    public void whenPushSmallAndBigThenMinIsSmall() {
        stackMin.push(1);
        stackMin.push(2);
        assertTrue(stackMin.min() == 1);
    }

    @Test
    public void whenPushBigAndSmallThenMinIsSmall() {
        stackMin.push(2);
        stackMin.push(1);
        assertTrue(stackMin.min() == 1);
    }

    @Test
    public void whenPushBigAndSmallAndPopThenMinIsSmall() {
        stackMin.push(2);
        stackMin.push(1);
        stackMin.pop();
        assertTrue(stackMin.min() == 2);
    }

    @Test
    public void whenPushBigAndSmallAndSmallAndPopThenMinIsSmall() {
        stackMin.push(2);
        stackMin.push(1);
        stackMin.push(1);
        stackMin.pop();
        assertTrue(stackMin.min() == 1);
    }
}
