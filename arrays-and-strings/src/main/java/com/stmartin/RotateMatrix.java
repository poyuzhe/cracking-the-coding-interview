package com.stmartin;

/**
 * Created by shentong on 2017/9/25.
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 * Hints: #51, #100
 */
class RotateMatrix {
    static byte[][][] rotateMatrix(byte[][][] matrix) {
        if (matrix == null) {
            return null;
        }
        if (matrix[0].length != matrix.length) {
            return null;
        }
        double center = matrix.length / 2;
        int oldX, oldY, newX, newY;
        byte[] beforeByte, afterByte;
        for (int x = 0; x <= center; x++) {
            for (int y = 0; y <= x; y++) {
                oldX = x;
                oldY = y;
                beforeByte = matrix[x][y];
                do {
                    newX = oldY;
                    newY = (int)(-(oldX - center) + center);
                    afterByte = matrix[newX][newY];
                    matrix[newX][newY] = beforeByte;
                    beforeByte = afterByte;
                    oldX = newX;
                    oldY = newY;
                } while (oldX != x || oldY != y);
            }
        }
        return matrix;
    }
}
