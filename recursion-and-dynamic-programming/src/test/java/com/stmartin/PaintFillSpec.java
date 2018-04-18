package com.stmartin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
input: a two dimensional array of int, and an element of this array, an int.
output: a new two dimensional array, with the element and all surrounding elements with the same color to change its
value to the input int.
 */
public class PaintFillSpec {
    private int[][] image;
    private int[][] newImage;
    private int newColor;
    private int firstIndex;
    private int secondIndex;

    @Before
    public void setUp() {
        this.image = new int[][]{{1,2,3,2},{1,2,2,3},{3,2,2,4}};
        this.newColor = 5;
        this.firstIndex = 1;
        this.secondIndex = 1;
        this.newImage = new int[][]{{1,5,3,2},{1,5,5,3}, {3,5,5,4}};
    }

    @Test
    public void paintFillSpec() {
        int[][] newImage = PaintFill.paintFill(image, firstIndex, secondIndex, newColor);
        Assert.assertArrayEquals(newImage, this.newImage);
    }
}
