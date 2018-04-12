package com.stmartin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
input: 2 positive integers.
output: the multiplication of these two integers.
rule: do not use * operator. can use addition, subtraction and bit shift, but limit their usages.
 */
public class RecursiveMultiplySpec {
    private int number1;
    private int number2;

    @Before
    public void setUp() {
        number1 = 34;
        number2 = 25;
    }

    @Test
    public void testRecursiveMultiply() {
        Assert.assertEquals(number1 * number2, RecursiveMultiply.recursiveMultiply(number1, number2));
    }
}
