package com.stmartin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
input: a string that may contain duplicate characters.
output: a set of strings which is all the permutations of the input string.
 */
public class PermutationsWithDupsSpec {
    private String original;

    @Before
    public void setUp() {
        this.original = "good";
    }

    @Test
    public void permutationsWithDupsSpec() {
        Assert.assertEquals(PermutationsWithDups.findPermutationsWithDups(original).size(), 12);
    }
}
