package com.stmartin;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;
import static com.stmartin.ZeroMatrix.*;

/**
 * Created by shentong on 2017/9/26.
 * spec:
 * 1. input is a 2 dimensional array with element of int.
 * 2. output is a 2 dimensional array with the same size.
 * 3. if an element of the input array is 0, then the sub-array the element belongs to is set to all 0.
 * 4. if an element of the input array is 0, then all sub-array's element of the same index is set to 0.
 * 5. specially, if the input is null or a array of length 0, then output is the same as input.
 */
public class ZeroMatrixSpec {
    private int[][] emptyMatrix = new int[][]{};
    private int[][] inputMatrix;
    private int[][] outputMatrix;

    @Before
    public void setUp() {
        Random generator = new Random();
        int rowLength = generator.nextInt(10);
        int columnLength = generator.nextInt(10);
        int zeroRow1 = generator.nextInt(rowLength);
        int zeroColumn1 = generator.nextInt(columnLength);
        int zeroRow2 = generator.nextInt(rowLength);
        int zeroColumn2 = generator.nextInt(columnLength);
        while(zeroColumn2 == zeroColumn1 && zeroRow1 == zeroRow2) {
            zeroRow2 = generator.nextInt(rowLength);
            zeroColumn2 = generator.nextInt(columnLength);
        }
        inputMatrix = new int[rowLength][columnLength];
        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                if ((row == zeroRow1 && column == zeroColumn1) || (row == zeroRow2 && column == zeroColumn2)) {
                    inputMatrix[row][column] = 0;
                } else {
                    inputMatrix[row][column] = 1;
                }
            }
        }
        outputMatrix = new int[rowLength][columnLength];
        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                if (row == zeroRow1 || column == zeroColumn1 || row == zeroRow2 || column == zeroColumn2) {
                    inputMatrix[row][column] = 0;
                } else {
                    inputMatrix[row][column] = 1;
                }
            }
        }
    }

    @Test
    public void whenNullOrZeroInputThenSameOutput() {
        assertArrayEquals(setZero(null), null);
        assertArrayEquals(setZero(emptyMatrix), emptyMatrix);
    }
    @Test
    public void whenHaveZeroThenSetRowAndColumnZero() {
        assertArrayEquals(setZero(inputMatrix), outputMatrix);
    }
}
