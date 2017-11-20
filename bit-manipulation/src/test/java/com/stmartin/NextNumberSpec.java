package com.stmartin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.stmartin.NextNumber.*;

/**
 * Created by shentong on 2017/11/20.
 * spec:
 * 1. input is a positive integer.
 * 2. output 1 is the next smallest int that has the same number of 1 bits as the input
 * 3. output 2 is the next largest int that has the same number of 1 bits as the input
 */
public class NextNumberSpec {
    private int input;
    private int nextSmallest;
    private int nextLargest;

    @Before
    public void setUp() {
        input = 14;
        nextLargest = 13;
        nextSmallest = 19;
    }

    @Test
    public void nextSmallestTest() {
        assertEquals(nextSmallestInt(input), nextSmallest);
    }

    @Test
    public void nextLargestTest() {
        assertEquals(nextLargestInt(input), nextLargest);
    }

    @Test
    public void nextSmallestEfficientTest() {
        assertEquals(nextSmallestIntEfficient(input), nextSmallest);
    }

    @Test
    public void nextLargestEfficientTest() {
        assertEquals(nextLargestIntEfficient(input), nextLargest);
    }
}
