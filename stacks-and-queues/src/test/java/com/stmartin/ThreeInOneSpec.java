package com.stmartin;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.EmptyStackException;

import static org.junit.Assert.*;
import static com.stmartin.ThreeInOne.*;

/**
 * Created by martinshen on 2017/10/3.
 * Spec:
 * 1. input is an array
 * 2. if the array's length is less than 3, then the output is null
 * 3. otherwise the output is an array of size 3, whose elements is of StackOnArray type
 * 4. each of the StackOnArray operate as independent stack, only when all three StackOnArray's size add up and exceed
 * the original array's size will a StackFullException throws.
 */
public class ThreeInOneSpec {
    Integer[] baseArray = new Integer[10];
    Integer[] shortArray = new Integer[2];

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void whenShortArrayThenReturnNull() {
        assertEquals(null, threeInOne(shortArray));
    }

    @Test
    public void whenNormalArrayThenReturnArrayOfStack() {
        assertEquals(threeInOne(baseArray).getClass(), StackOnArray.class);
    }

    @Test
    public void whenPushOneElementThenCorrectPeekAndPop() {
        StackOnArray<Integer> stacks = threeInOne(baseArray);
        stacks.push(0, 1);
        stacks.push(1, 2);
        stacks.push(2, 3);
        assertTrue(stacks.peek(0) == 1);
        assertTrue(stacks.peek(1) == 2);
        assertTrue(stacks.peek(2) == 3);
        assertTrue(stacks.pop(0) == 1);
        assertTrue(stacks.pop(1) == 2);
        assertTrue(stacks.pop(2) == 3);
    }

    @Test
    public void whenStackEmptyThenTestEmpty() {
        StackOnArray<Integer> stacks = threeInOne(baseArray);
        assertTrue(stacks.isEmpty(0));
        assertTrue(stacks.isEmpty(1));
        assertTrue(stacks.isEmpty(2));
    }

    @Test
    public void whenPushOneElementThenTestNotEmpty() {
        StackOnArray<Integer> stacks = threeInOne(baseArray);
        stacks.push(0, 1);
        stacks.push(1, 2);
        stacks.push(2, 3);
        assertFalse(stacks.isEmpty(0));
        assertFalse(stacks.isEmpty(1));
        assertFalse(stacks.isEmpty(2));
    }

    @Test
    public void whenPopOrPeekEmptyStackThenThrowException() {
        StackOnArray<Integer> stacks = threeInOne(baseArray);
        exception.expect(EmptyStackException.class);
        stacks.pop(0);
        exception.expect(EmptyStackException.class);
        stacks.peek(0);
    }

    @Test
    public void whenPushOverCapacityAndArrayNotFullThenDoNotThrowException() {
        StackOnArray<Integer> stacks = threeInOne(baseArray);
        stacks.push(0, 1);
        stacks.push(0, 2);
        stacks.push(0, 3);
        stacks.push(0, 4);
    }

    @Test
    public void whenAllStackFullAndPushThenThrowStackFullException() {
        StackOnArray<Integer> stacks = threeInOne(baseArray);
        stacks.push(0, 1);
        stacks.push(0, 2);
        stacks.push(0, 3);
        stacks.push(1, 4);
        stacks.push(1, 5);
        stacks.push(1, 6);
        stacks.push(2, 7);
        stacks.push(2, 8);
        stacks.push(2, 9);
        stacks.push(0, 10);
        exception.expect(StackFullException.class);
        stacks.push(1, 11);
    }

    @Test
    public void whenThirdStackIncreaseCapacityAndPopThenNoException() {
        StackOnArray<Integer> stacks = threeInOne(baseArray);
        stacks.push(2, 1);
        stacks.push(2, 2);
        stacks.push(2, 3);
        stacks.push(2, 4);
        stacks.push(2, 5);
        stacks.pop(2);
        stacks.pop(2);
        stacks.pop(2);
        stacks.pop(2);
    }
}
