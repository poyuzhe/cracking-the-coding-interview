package com.stmartin;

import com.sun.deploy.security.ruleset.ExceptionRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by martinshen on 2017/10/3.
 * spec:
 * 1. design a class which holds multiple stacks.
 * 2. when one stack is full, a new push will create a new stack and push to new one.
 * 3. when one child stack is empty, pop and peek returns the previous stack's last element.
 * 4. have an operation popAt(index) which pop at a specific child stack.
 */
public class StackOfPlatesSpec {
    StackOfPlates<Integer> stacks;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        stacks = new StackOfPlates<>(3);
    }

    @Test
    public void whenFirstStackFullThenPushOK() {
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
    }

    @Test
    public void whenSecondStackEmptyThenPopAndPeekOK() {
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.pop();
        stacks.peek();
        stacks.pop();
    }

    @Test
    public void whenPopAtThenPopAt() {
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        assertTrue(stacks.popAt(0) == 3);
    }
}
