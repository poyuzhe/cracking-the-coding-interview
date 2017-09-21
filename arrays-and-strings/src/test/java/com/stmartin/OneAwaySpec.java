package com.stmartin;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by shentong on 2017/9/21.
 * spec:
 * 1. basic operations include insert a character, remove a character and replace a character
 * 2. given two strings, check to see if these two strings are one basic operation away from each other.
 * 3. assume the encoding is UTF-16
 */
public class OneAwaySpec {
    private String baseStr;
    private String baseStrPlusOne;
    private String baseStrMinusOne;
    private String baseStrChangeOne;
    private String notOneAwayStr;

    @Before
    public void setUp() {
        baseStr = "helloWorld!";
        baseStrPlusOne = "helloyWorld!";
        baseStrMinusOne = "heloWorld!";
        baseStrChangeOne = "hello好orld!";
        notOneAwayStr = "hellow好rld?";
    }

    @Test
    public void whenAnyNullStringThenNotOneAway() {
        assertFalse(OneAway.oneAway(null, baseStr));
    }

    @Test
    public void whenIdenticalStringsThenOneAway() {
        assertTrue(OneAway.oneAway(baseStr, baseStr));
    }

    @Test
    public void whenOneInsertAwayThenOneAway() {
        assertTrue(OneAway.oneAway(baseStr, baseStrPlusOne));
    }

    @Test
    public void whenOneRemoveAwayThenOneAway() {
        assertTrue(OneAway.oneAway(baseStr, baseStrMinusOne));
    }

    @Test
    public void whenOneReplaceAwayThenOneAway() {
        assertTrue(OneAway.oneAway(baseStr, baseStrChangeOne));
    }

    @Test
    public void whenTwoOrMoreChangeAwayThenNotOneWay() {
        assertFalse(OneAway.oneAway(baseStr, notOneAwayStr));
    }

    @Test
    public void whenAnyNullStringThenNotOneAwayHighLevel() {
        assertFalse(OneAway.oneAwayHighLevel(null, baseStr));
    }

    @Test
    public void whenIdenticalStringsThenOneAwayHighLevel() {
        assertTrue(OneAway.oneAwayHighLevel(baseStr, baseStr));
    }

    @Test
    public void whenOneInsertAwayThenOneAwayHighLevel() {
        assertTrue(OneAway.oneAwayHighLevel(baseStr, baseStrPlusOne));
    }

    @Test
    public void whenOneRemoveAwayThenOneAwayHighLevel() {
        assertTrue(OneAway.oneAwayHighLevel(baseStr, baseStrMinusOne));
    }

    @Test
    public void whenOneReplaceAwayThenOneAwayHighLevel() {
        assertTrue(OneAway.oneAwayHighLevel(baseStr, baseStrChangeOne));
    }

    @Test
    public void whenTwoOrMoreChangeAwayThenNotOneWayHighLevel() {
        assertFalse(OneAway.oneAwayHighLevel(baseStr, notOneAwayStr));
    }
}
