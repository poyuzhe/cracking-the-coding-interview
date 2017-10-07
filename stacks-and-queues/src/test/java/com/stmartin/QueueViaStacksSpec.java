package com.stmartin;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by martinshen on 2017/10/3.
 * Spec:
 * design a queue class which utilize two stacks
 */
public class QueueViaStacksSpec {
    QueueViaStacks<Integer> myQueue;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        myQueue = new QueueViaStacks<>();
    }

    @Test
    public void whenOnlyAddThenOk() {
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
    }

    @Test
    public void whenAddAndRemoveThenOk() {
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.remove();
        myQueue.remove();
        assertTrue(myQueue.peek() == 3);
        myQueue.remove();
        myQueue.add(1);
        assertTrue(myQueue.peek() == 1);
    }
}
