package com.stmartin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.stmartin.PairwiseSwap.*;

/**
 * Created by shentong on 2017/11/23.
 * Spec:
 * 1. input is an integer
 * 2. output is an integer formed by swapping the odd and even bits of the input, such as swapping 0 bit and 1 bit,
 * swapping 2 bit and 3 bit.
 * 3. need to use as few instructions as possible.
 */
public class PairwiseSwapSpec {
    private int input;
    private int output;

    @Before
    public void setUp() {
        input = 21;
        output = 42;
    }

    @Test
    public void swapPairwiseTest() {
        assertEquals(output, pairwiseSwap(input));
    }

    @Test
    public void swapPairwiseEfficientTest() {
        assertEquals(output, pairwiseSwapEfficient(input));
    }
}
