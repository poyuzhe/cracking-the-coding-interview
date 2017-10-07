package com.stmartin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.stmartin.SortStack.*;

import java.util.Stack;

/**
 * Created by martinshen on 2017/10/3.
 * Spec:
 * 1. input is a stack of Comparable type.
 * 2. output is the same stack with item sorted so that smaller item is on top.
 * 3. can use another stack as temporary storage but no other data structure
 */
public class SortStackSpec {
    Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(3);
    }

    @Test
    public void whenNormalReturnSorted() {
        Stack<Integer> sorted = sortStack(stack);
        assertTrue(sorted.pop() == 1);
        assertTrue(sorted.pop() == 2);
        assertTrue(sorted.pop() == 3);
        assertTrue(sorted.pop() == 3);
        assertTrue(sorted.pop() == 4);
    }
}
