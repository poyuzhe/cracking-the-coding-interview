package com.stmartin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.stmartin.Insertion.*;

/**
 * Created by shentong on 2017/11/16.
 * Spec:
 * 1. input is 2 int as N ans M, and 2 int i and j in the range of 0-31. The difference between i and j should be bigger
 * than the bit length of M.
 * 2. output is another int where the i bit through j bit of N is replaced by M.
 */
public class InsertionSpec {
    private int N;
    private int M;
    private int i;
    private int j;
    private int result;

    @Before
    public void setUp() {
        N = 1024;
        M = 19;
        i = 2;
        j = 6;
        result = 1100;
    }

    @Test
    public void insertionTest() {
        assertEquals(result, insertion(N, M, i, j));
    }

    @Test
    public void insertionMergeTest() {
        assertEquals(result, insertionMerge(N, M, i, j));
    }
}
