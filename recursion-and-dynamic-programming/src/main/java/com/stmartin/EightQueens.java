package com.stmartin;

import java.util.ArrayList;
import java.util.List;

/*
Eight Queens: Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board
so that none of them share the same row, column, or diagonal. In this case, "diagonal" means all
diagonals, not just the two that bisect the board.
Hints: #308 , #350 , #371
*/
class EightQueens {
    static List<int[][]> getAllEightQueenPositions() {
        List<int[][]> result = new ArrayList<>();
        int[][] empty = new int[8][8];
        findNextPosition(empty, 0, result);
        return result;
    }

    private static void findNextPosition(int[][] existing, int rowIndex, List<int[][]> result) {
        if (rowIndex == existing.length) {
            result.add(existing);
            return;
        }

        for (int j = 0; j < existing[0].length; j++) {
            if (existing[rowIndex][j] == 0) {
                int[][] updated = deepClone(existing);
                fillRow(updated, rowIndex, 2);
                fillColumn(updated, j, 2);
                fillDiagonal(updated, rowIndex, j, 2);
                updated[rowIndex][j] = 1;
                findNextPosition(updated, rowIndex + 1, result);
            }
        }
    }

    private static void fillRow(int[][] existing, int rowIndex, int newValue) {
        for (int j = 0; j < existing[0].length; j++) {
            existing[rowIndex][j] = newValue;
        }
    }

    private static void fillColumn(int[][] existing, int columnIndex, int newValue) {
        for (int i = 0; i < existing.length; i++) {
            existing[i][columnIndex] = newValue;
        }
    }

    private static void fillDiagonal(int[][] existing, int rowIndex, int columnIndex, int newValue) {
        for (int j = 0; j < columnIndex; j++) {
            if (rowIndex - (columnIndex - j) >= 0) {
                existing[rowIndex - (columnIndex - j)][j] = newValue;
            }
            if (rowIndex + (columnIndex - j) < existing.length) {
                existing[rowIndex + (columnIndex - j)][j] = newValue;
            }
        }
        for (int j = columnIndex + 1; j < existing[0].length; j++) {
            if (rowIndex - (columnIndex - j) < existing.length) {
                existing[rowIndex - (columnIndex - j)][j] = newValue;
            }
            if (rowIndex + (columnIndex - j) >= 0) {
                existing[rowIndex + (columnIndex - j)][j] = newValue;
            }
        }
    }

    private static int[][] deepClone(int[][] original) {
        int[][] clone = original.clone();
        for (int i = 0; i < original.length; i++) {
            clone[i] = original[i].clone();
        }
        return clone;
    }
}
