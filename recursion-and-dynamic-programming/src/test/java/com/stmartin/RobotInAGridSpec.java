package com.stmartin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.stmartin.RobotInAGrid.Direction;
import static com.stmartin.RobotInAGrid.findRobotPath;

/*
spec:
1. input: a two dimensional array of boolean value, where a true represent a cell which the robot can step on, and a
false represent a cell which the robot can't step on.
2. output: an array of Directions representing the order of movements the robot can use to move from the top-left cell
to the bottom-right cell, or null if such a path does not exist.
3. if more than one solution exists for the grid, always find the one that move right whenever possible.
 */
public class RobotInAGridSpec {
    private boolean[][] solvableGrid;
    private boolean[][] unSolvableGrid;
    private Direction[] solution;

    @Before
    public void setUp() {
        solvableGrid = new boolean[3][4];
        solvableGrid[0][0] = true;
        solvableGrid[1][0] = true;
        solvableGrid[2][0] = false;
        solvableGrid[0][1] = true;
        solvableGrid[1][1] = false;
        solvableGrid[2][1] = true;
        solvableGrid[0][2] = true;
        solvableGrid[1][2] = true;
        solvableGrid[2][2] = true;
        solvableGrid[0][3] = false;
        solvableGrid[1][3] = true;
        solvableGrid[2][3] = true;

        solution = new Direction[5];
        solution[0] = Direction.right;
        solution[1] = Direction.right;
        solution[2] = Direction.down;
        solution[3] = Direction.right;
        solution[4] = Direction.down;

        unSolvableGrid = new boolean[3][4];
        unSolvableGrid[0][0] = true;
        unSolvableGrid[1][0] = true;
        unSolvableGrid[2][0] = false;
        unSolvableGrid[0][1] = true;
        unSolvableGrid[1][1] = false;
        unSolvableGrid[2][1] = true;
        unSolvableGrid[0][2] = true;
        unSolvableGrid[1][2] = true;
        unSolvableGrid[2][2] = false;
        unSolvableGrid[0][3] = false;
        unSolvableGrid[1][3] = false;
        unSolvableGrid[2][3] = true;
    }

    @Test
    public void whenSolvableThenSolutionCorrect() {
        Assert.assertArrayEquals(solution, findRobotPath(solvableGrid));
    }

    @Test
    public void whenUnsolvableThenNull() {
        Assert.assertArrayEquals(null, findRobotPath(unSolvableGrid));
    }
}
