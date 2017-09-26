package com.stmartin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shentong on 2017/9/26.
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to O.
 * Hints: #17, #74, #102
 */
class ZeroMatrix {
    static int[][] setZero(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroColumns = new HashSet<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] == 0) {
                    zeroRows.add(row);
                    zeroColumns.add(column);
                }
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (zeroRows.contains(row)) {
                    matrix[row][column] = 0;
                } else if (zeroColumns.contains(column)) {
                    matrix[row][column] = 0;
                }
            }
        }
        return matrix;
    }
}
