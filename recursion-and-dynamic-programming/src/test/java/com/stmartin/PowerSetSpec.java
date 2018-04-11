package com.stmartin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.stmartin.PowerSet.*;

/*
input: a set of integers.
output: a list of sets containing all subsets of the input.
 */
public class PowerSetSpec {
    private Set<Integer> fullSet;

    @Before
    public void setUp() {
        fullSet = new HashSet<>();
        fullSet.add(1);
        fullSet.add(2);
        fullSet.add(3);
    }

    @Test
    public void testGetAllSubSets() {
        Assert.assertEquals(7, getSubsets(fullSet).size());
    }
}
