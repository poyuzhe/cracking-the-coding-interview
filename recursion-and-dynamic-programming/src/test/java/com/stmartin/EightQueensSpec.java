package com.stmartin;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/*
input: a two dimensional int array that represent the current board placement.
output: a list of two dimensional int arrays which represent all possible placement of eight queens on a 8*8 chess board
so that no 2 queens are in the same row, column or diagonal.
 */
public class EightQueensSpec {

    @Test
    public void testEightQueens() {
        List<int[][]> result = EightQueens.getAllEightQueenPositions();
        Assert.assertEquals(result.size(), 92);
    }
}
