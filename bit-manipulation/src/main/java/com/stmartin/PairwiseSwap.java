package com.stmartin;

/**
 * Created by shentong on 2017/11/23.
 * Pairwise Swap: Write a program to swap odd and even bits in an integer with as few instructions as
 possible (e . g. , bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 Hints : #145, #248, #328, #355
 */
class PairwiseSwap {
    static int pairwiseSwap(int input) {
        for (int i = 0; i < 32; i += 2) {
            input = swapTwoBits(input, i, i+1);
        }
        return input;
    }

    static private int swapTwoBits(int input, int index1, int index2) {
        // acquire the value of the index1
        int bitOfIndex1 = (input & (1 << index1)) == 0 ? 0 : 1;
        // acquire the value of the index2
        int bitOfIndex2 = (input & (1 << index2)) == 0 ? 0 : 1;
        // set the value of the index1 to the value of index2
        if (bitOfIndex2 != bitOfIndex1) {
            if (bitOfIndex2 == 1) {
                input = input | (1 << index1);
                input = input ^ (1 << index2);
            } else {
                input = input | (1 << index2);
                input = input ^ (1 << index1);
            }
        }
        return input;
        // set the value of the index2 to the value of index1
    }
}
