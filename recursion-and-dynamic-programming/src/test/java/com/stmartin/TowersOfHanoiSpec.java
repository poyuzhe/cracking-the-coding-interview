package com.stmartin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

/*
input: three stacks, one contains plates of various sizes, the other 2 are empty. the plates in the stack is in ascending
order where the biggest one is at the bottom of the stack.
output: the originally empty stack filled with plates in the same ascending order.
rule: the plates can only be moved between different stacks. a plate can only be placed on top of another bigger plate.
constraints: 1. one plate at a time. 2. move from the top of the tower and onto the top of another tower. 3. smaller plates
on top.
 */
public class TowersOfHanoiSpec {
    private Stack<Double> tower1;
    private Stack<Double> tower2;
    private Stack<Double> tower3;

    @Before
    public void setUp() {
        tower1 = new Stack<>();
        tower2 = new Stack<>();
        tower3 = new Stack<>();
        tower1.push(5.0);
        tower1.push(4.0);
        tower1.push(3.0);
        tower1.push(2.0);
        tower1.push(1.0);
    }

    @Test
    public void testMovePlatesTo3rdTower() {
        TowersOfHanoi.movePlatesTo3rdTower(tower1, tower2, tower3);
        Assert.assertEquals(1.0, tower3.pop(), 0);
        Assert.assertEquals(2.0, tower3.pop(), 0);
        Assert.assertEquals(3.0, tower3.pop(), 0);
        Assert.assertEquals(4.0, tower3.pop(), 0);
        Assert.assertEquals(5.0, tower3.pop(), 0);
    }
}
