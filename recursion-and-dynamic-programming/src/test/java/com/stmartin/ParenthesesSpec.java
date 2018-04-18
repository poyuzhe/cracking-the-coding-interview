package com.stmartin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/*
input: a positive integer n
output: a set of strings contains all combinations of n pairs of valid parentheses.
 */
public class ParenthesesSpec {
    private int numberOfPairsOfParentheses;
    private Set<String> combinations;

    @Before
    public void setUp() {
        this.numberOfPairsOfParentheses = 3;
        this.combinations = new HashSet<>();
        combinations.add("((()))");
        combinations.add("(()())");
        combinations.add("(())()");
        combinations.add("()(())");
        combinations.add("()()()");
    }

    @Test
    public void findAllCombinationsOfParenthesesSpec() {
        Set<String> result = Parentheses.findAllValidCombinationsOfParentheses(numberOfPairsOfParentheses);
        Assert.assertEquals(result.size(), combinations.size());
        combinations.forEach(s -> Assert.assertTrue(result.contains(s)));
    }

    @Test
    public void findAllCombinationsOfParenthesesByStepSpec() {
        Set<String> result = Parentheses.findAllValidCombinationsOfParenthesesByStep(numberOfPairsOfParentheses);
        Assert.assertEquals(result == null ? 0 : result.size(), combinations.size());
        combinations.forEach(s -> Assert.assertTrue(result != null && result.contains(s)));
    }
}
