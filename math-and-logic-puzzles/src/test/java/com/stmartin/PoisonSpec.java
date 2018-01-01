package com.stmartin;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static com.stmartin.Poison.*;

/*
Spec:
1. for return test result by bottle index, the function takes an integer between 1 and 1000 inclusive, and return a
boolean array with 10 elements.
2. for the deduce poisoned bottle index by test result, the function takes a boolean array with 10 elements and return
an integer between 1 and 1000 inclusive.
3. the input of the first function and the result of the second function should be identical.
 */
public class PoisonSpec {
    @Test
    public void randomPoisonedBottleIndexRetractableSpec() {
        int index = new Random().nextInt(1000) + 1;
        Assert.assertEquals(index, deducePoisonedBottleIndexByTestResult(returnTestResultForPoisonedBottle(index)));
    }
}
