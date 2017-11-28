package com.stmartin;

import javax.swing.*;

/**
 * Created by shentong on 2017/11/27.
 * Draw Line: A monochrome screen is stored as a single array of bytes, allowing eight consecutive
 pixels to be stored in one byte. The screen has width w, where w is divisible by 8 (that is, no byte will
 be split across rows). The height of the screen, of course, can be derived from the length of the array
 and the width . Implement a function that draws a horizontal line from (xl, y) to (x2, y).
 The method signature should look something like:
 drawLine(byte[] screen, int width, int xl, int x2, int y)
 Hints: #366, #381, #384, #391
 */
class DrawLine {
    static int[] drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int a1 = width * y + x1;
        int a2 = width * y + x2;
        int index1 = a1 / 8;
        int index2 = a2 / 8;
        int bit1 = a1 - index1 * 8;
        int bit2 = a2 - index2 * 8;
        int[] line = new int[x2 - x1 + 1];
        byte start = screen[index1];
        if (index1 == index2) {
            for (int i = 0; i <= bit2 - bit1; i++) {
                line[i] = (start & (1 << (i + bit1))) == 0 ? 0 : 1;
            }
        } else {
            for (int i = 0; i < 8 - bit1; i++) {
                line[i] = (start & (1 << (i + bit1))) == 0 ? 0 : 1;
            }
            for (int loop = index1 + 1; loop < index2; loop++) {
                for (int i = 0; i < 8; i++) {
                    line[8 - bit1 + 8 * (loop - index1 - 1) + i] = (screen[loop] & (1 << i)) == 0 ? 0 : 1;
                }
            }
            for (int i = 0; i <= bit2; i++) {
                line[8 - bit1 + 8 * (index2 - index1 - 1) + i] = (screen[index2] & (1 << i)) == 0 ? 0 : 1;
            }
        }
        return line;
    }
}
