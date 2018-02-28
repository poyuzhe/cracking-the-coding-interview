package com.stmartin;

import org.junit.Assert;
import org.junit.Test;

import static com.stmartin.TripleSteps.*;

/*
spec:
1. input: the total number of steps.
2. rule: one can jump 1 step, 2 steps or 3 steps at a time.
3. output: the possible number of ways one can go up the whole stair.
 */
public class TripleStepsSpec {
    @Test
    public void when1StepsThen1() {
        Assert.assertEquals(1, countSteps(1));
    }

    @Test
    public void when2StepsThen2() {
        Assert.assertEquals(2, countSteps(2));
    }

    @Test
    public void when3StepsThen4() {
        Assert.assertEquals(4, countSteps(3));
    }

    @Test
    public void when4StepsThen7() {
        Assert.assertEquals(7, countSteps(4));
    }

    @Test
    public void when1StepsThen1TopDown() {
        Assert.assertEquals(1, countStepsTopDown(1));
    }

    @Test
    public void when2StepsThen2TopDown() {
        Assert.assertEquals(2, countStepsTopDown(2));
    }

    @Test
    public void when3StepsThen4TopDown() {
        Assert.assertEquals(4, countStepsTopDown(3));
    }

    @Test
    public void when4StepsThen7TopDown() {
        Assert.assertEquals(7, countStepsTopDown(4));
    }

    @Test
    public void testComplexity() {
        for (int totalSteps = 1; totalSteps <= 10; totalSteps++) {
            countSteps(totalSteps);
            countStepsTopDown(totalSteps);
        }
    }
}
