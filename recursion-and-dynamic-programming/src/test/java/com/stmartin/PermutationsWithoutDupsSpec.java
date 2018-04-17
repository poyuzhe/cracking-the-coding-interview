package com.stmartin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
input: a string with unique characters.
output: a set of strings which are all the permutations of the input string.
 */
public class PermutationsWithoutDupsSpec {
    private String unique;

    @Before
    public void setUp() {
        this.unique = "show";
    }

    @Test
    public void findPermutationsWithoutDupsSpec() {
        Assert.assertEquals(PermutationsWithoutDups.findAllPermutationsOfUniqueString(unique).size(), 24);
    }
}
