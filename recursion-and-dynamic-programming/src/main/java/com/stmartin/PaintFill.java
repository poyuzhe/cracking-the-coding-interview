package com.stmartin;

import java.util.Arrays;

/*
Paint Fill: Implement the "paint fill" function that one might see on many image editing programs.
That is , given a screen (represented by a two-dimensional array of colors), a point, and a new color,
fill in the surrounding area until the color changes from the original color.
Hints: #364, #382
*/
class PaintFill {
    static int[][] paintFill(int[][] image, int firstIndex, int secondIndex, int newColor) {
        if (image == null || firstIndex >= image.length || firstIndex < 0 || secondIndex >= image[0].length || secondIndex < 0) {
            return null;
        }
        int oldColor = image[firstIndex][secondIndex];
        int[][] newImage = image.clone();
        doPaintFill(newImage, firstIndex, secondIndex, newColor, oldColor);
        return newImage;
    }

    private static void doPaintFill(int[][] image, int firstIndex, int secondIndex, int newColor, int oldColor) {
        if (firstIndex < 0 || firstIndex >= image.length || secondIndex < 0 || secondIndex >= image[0].length) {
            return;
        }
        if (image[firstIndex][secondIndex] != oldColor) {
            return;
        }

        image[firstIndex][secondIndex] = newColor;

        doPaintFill(image, firstIndex - 1, secondIndex, newColor, oldColor);
        doPaintFill(image, firstIndex + 1, secondIndex, newColor, oldColor);
        doPaintFill(image, firstIndex, secondIndex - 1, newColor, oldColor);
        doPaintFill(image, firstIndex, secondIndex + 1, newColor, oldColor);
    }
}
