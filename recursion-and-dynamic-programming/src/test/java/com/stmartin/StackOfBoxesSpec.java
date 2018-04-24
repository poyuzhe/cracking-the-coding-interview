package com.stmartin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.stmartin.StackOfBoxes.*;

/*
input: a list of boxes with distinct width, height and depth.
output: the height of the tallest stack where each box is placed on top of another box whose width, height and depth are
all bigger than itself's.
 */
public class StackOfBoxesSpec {
    private List<Box> boxes;
    private int maxHeight;

    @Before
    public void setUp() {
        boxes = new ArrayList<>();
        boxes.add(new Box(30, 30, 30));
        boxes.add(new Box(40, 20, 29));
        boxes.add(new Box(20, 50, 33));
        boxes.add(new Box(35, 35, 35));
        boxes.add(new Box(25, 40, 40));
        boxes.add(new Box(22, 37, 37));

        maxHeight = 77;
    }

    @Test
    public void findMaxHeightOfStackOfBoxes() {
        Assert.assertEquals(maxHeight, calculateTallestPossibleStack(boxes));
    }
}
