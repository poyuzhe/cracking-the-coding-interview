package com.stmartin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
input: an integer n, number of cents
output: the number of ways n cents can be represented by the sum of any number of quarters(25), dimes(10), nickels(5) and pennies(1).
 */
public class CoinsSpec {
    private int cents;
    private int ways;

    @Before
    public void setUp() {
        this.cents = 25;
        this.ways = 13;
    }

    @Test
    public void numberOfWaysToCalculateNCentsSpec() {
        Assert.assertEquals(this.ways, Coins.numberOfWaysToCalculateNCents(cents).size());
    }
}
