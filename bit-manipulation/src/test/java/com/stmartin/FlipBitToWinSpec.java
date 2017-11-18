package com.stmartin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.stmartin.FlipBitToWin.*;

/**
 * Spec:
 * 1. input is an integer.
 * 2. use the binary representation of the integer. the code can flip any one of the 0 into 1. and the code can try to
 * determine the longest sequence of consecutive 1s this flip can potentially create.
 * 3. output is an integer representing the longest sequence.
 */
public class FlipBitToWinSpec {
    private int input;
    private int length;

    @Before
    public void setUp() {
        this.input = 1775;
        this.length = 8;
    }

    @Test
    public void testFlipBitToWin() {
        assertEquals(findLongestSequenceOfOneWithOneZeroInBetween(input), length);
    }
}
