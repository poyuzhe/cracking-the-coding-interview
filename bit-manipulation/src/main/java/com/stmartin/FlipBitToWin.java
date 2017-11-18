package com.stmartin;

import java.util.Arrays;

/**
 * Flip Bit to Win: You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to
 find the length of the longest sequence of ls you could create.
 EXAMPLE
 Input: 1775 (or: 11011101111)
 Output: 8
 Hints : #159, #226, #314, #352
 */
class FlipBitToWin {
    static int findLongestSequenceOfOneWithOneZeroInBetween(int input) {
        int maxLength = 0;
        int lastZero = -1;
        int flip = -1;
        int i;
        for (i = 0; i < 32; i++) {
            int iBit = input & (1 << i);
            if (iBit == 0 ) {
                if (flip != -1) {
                    int length = i - lastZero - 1;
                    if (length > maxLength) {
                        maxLength = length;
                    }
                    lastZero = flip;
                }
                flip = i;
            }
        }
        if (i - lastZero - 1 > maxLength) {
            maxLength = i - lastZero - 1;
        }

        return maxLength;
    }
}
