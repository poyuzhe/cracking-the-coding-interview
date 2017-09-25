package com.stmartin;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.stmartin.RotateMatrix.*;

/**
 * Created by shentong on 2017/9/25.
 * spec:
 * 1. input is a 3-Dimensional byte array, where the first 2 dimension has the same length, and the 3rd dimension has a length of 4.
 * 2. rotate the matrix 90 degrees clockwise.
 * 3. do it in place without any additional data structures.
 */
public class RotateMatrixSpec {
    byte[][][] correctMatrix = new byte[3][3][4];
    byte[][][] transformedMatrix = new byte[3][3][4];
    byte[][][] differentDimensionMatrix = new byte[3][4][4];

    @Before
    public void setUp() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    correctMatrix[i][j][k] = (byte)(i * 100 + j * 10 + k);
                }
            }
        }
        transformedMatrix[0][0] = correctMatrix[2][0];
        transformedMatrix[0][1] = correctMatrix[1][0];
        transformedMatrix[0][2] = correctMatrix[0][0];
        transformedMatrix[1][2] = correctMatrix[0][1];
        transformedMatrix[2][2] = correctMatrix[0][2];
        transformedMatrix[2][1] = correctMatrix[1][2];
        transformedMatrix[2][0] = correctMatrix[2][2];
        transformedMatrix[1][0] = correctMatrix[2][1];
        transformedMatrix[1][1] = correctMatrix[1][1];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    differentDimensionMatrix[i][j][k] = (byte)(i * 100 + j * 10 + k);
                }
            }
        }
    }

    @Test
    public void whenEmptyInputThenEmptyOutput() {
        assertArrayEquals(rotateMatrix(null), null);
    }

    @Test
    public void whenFirst2DimensionNotEqualThenEmptyOutput() {
        assertArrayEquals(rotateMatrix(differentDimensionMatrix), null);
    }

    @Test
    public void whenCorrectInputThenRotate90Degrees() {
        assertArrayEquals(rotateMatrix(correctMatrix), transformedMatrix);
    }
}
