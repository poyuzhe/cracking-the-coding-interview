package com.stmartin;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/*
Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
The robot can only move in two directions, right and down, but certain cells are "off limits" such that
the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
the bottom right.
Hints: #331, #360, #388
 */
class RobotInAGrid {
    public enum Direction {
        right,
        down
    }

    static Direction[] findRobotPath(boolean[][] grid) {
        Direction[] movements = new Direction[grid.length + grid[0].length - 2];
        AtomicInteger count = new AtomicInteger(0);
        HashSet<String> failedCells = new HashSet<>();
        boolean solvable = move(grid, 0, 0, movements, count, failedCells);
        System.out.println("total move calls: " + count.get());
        if (solvable) {
            return movements;
        }
        return null;
    }

    private static boolean move(boolean[][] grid, int rowIndex, int columnIndex, Direction[] movements,
                                AtomicInteger count, Set<String> failedCells) {
        if (failedCells.contains(rowIndex + "_" + columnIndex)) {
            return false;
        }

        count.incrementAndGet();
        if (rowIndex == grid.length - 1 && columnIndex == grid[0].length - 1) {
            return true;
        }

        int moveIndex = rowIndex + columnIndex;
        boolean moveResult = false;
        if (canMoveRight(grid, rowIndex, columnIndex)) {
            moveResult = move(grid, rowIndex, columnIndex + 1, movements, count, failedCells);
            if (moveResult) {
                movements[moveIndex] = Direction.right;
            }
        }
        if (!moveResult && canMoveDown(grid, rowIndex, columnIndex)) {
            moveResult = move(grid, rowIndex + 1, columnIndex, movements, count, failedCells);
            if (moveResult) {
                movements[moveIndex] = Direction.down;
            }
        }

        if (!moveResult) {
            failedCells.add(rowIndex + "_" + columnIndex);
        }
        return moveResult;
    }

    private static boolean canMoveRight(boolean[][] grid, int rowIndex, int columnIndex) {
        return rowIndex < grid.length && rowIndex >= 0
                && columnIndex >= 0 && columnIndex + 1 < grid[0].length
                && grid[rowIndex][columnIndex + 1];
    }

    private static boolean canMoveDown(boolean[][] grid, int rowIndex, int columnIndex) {
        return rowIndex + 1< grid.length && rowIndex >= 0
                && columnIndex >= 0 && columnIndex < grid[0].length
                && grid[rowIndex + 1][columnIndex];
    }
}
