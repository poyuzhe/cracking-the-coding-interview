package com.stmartin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.stmartin.MagicIndex.*;

/*
input: a sorted int array A, in ascending order, either distinct or non-distinct.
output: the index i where A[i] = i, or null if such an index does not exist.
 */
public class MagicIndexSpec {
    private int[] distinctHavingArray;
    private int[] distinctHavingNotArray;
    private int[] nonDistinctHavingArray;
    private int[] nonDistinctHavingNotArray;

    @Before
    public void setUp() {
        distinctHavingArray = new int[]{-1, 0, 2, 4, 5, 7, 9, 10};
        distinctHavingNotArray = new int[]{-1, 0, 1, 2, 3, 4, 5, 6};
        nonDistinctHavingArray = new int[]{-1, 0, 2, 2, 5, 6, 9, 10};
        nonDistinctHavingNotArray = new int[]{-1, 0, 0, 2, 3, 4, 4, 6, 7};
    }

    @Test
    public void testFindIndexOfDistinctHavingArray() {
        Assert.assertEquals(findMagicIndexInDistinctArray(distinctHavingArray), new Integer(2));
    }

    @Test
    public void testFindIndexOfDistinctHavingNotArray() {
        Assert.assertNull(findMagicIndexInDistinctArray(distinctHavingNotArray));
    }

    @Test
    public void testFindIndexOfNonDistinctHavingArray() {
        Assert.assertEquals(findMagicIndexInNonDistinctArray(nonDistinctHavingArray), new Integer(2));
    }

    @Test
    public void testFindIndexOfNonDistinctHavingNotArray() {
        Assert.assertNull(findMagicIndexInNonDistinctArray(nonDistinctHavingNotArray));
    }
}
