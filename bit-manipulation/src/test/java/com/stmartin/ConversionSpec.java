package com.stmartin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.stmartin.Conversion.*;

/**
 * Created by shentong on 2017/11/22.
 * spec:
 * 1. input is two integers.
 * 2. output is the number of bits one needs to flip in order to convert from one integer to another.
 */
public class ConversionSpec {
    private int a;
    private int b;
    private int count;

    @Before
    public void setUp() {
        a = 29;
        b = 15;
        count = 2;
    }

    @Test
    public void testCountBitsToFlip() {
        assertEquals(count, countBitsToFlip(a, b));
    }
}
