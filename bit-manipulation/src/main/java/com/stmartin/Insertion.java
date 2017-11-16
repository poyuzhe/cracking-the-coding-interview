package com.stmartin;

/**
 * Created by shentong on 2017/11/16.
 * Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and
 j. Write a method to insert M into N such that M starts at bit j and ends at bit i. You
 can assume that the bits j through i have enough space to fit all of M. That is, if
 M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for
 example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 EXAMPLE
 Input: N = 10000000000, M = 10011, i = 2, j = 6
 Output: N = 10001001100
 Hints : #137, #169, #215
 */
class Insertion {
    static int insertion(int N, int M, int i, int j) {
        int i2jSet1 = (int)Math.pow(2, j - i) << i;
        int i2jSet0 = ~i2jSet1;
        int Ni2jSet0 = N & i2jSet0;
        int MLeftShiftI = M << i;
        int NReplaceM = Ni2jSet0 | MLeftShiftI;
        return NReplaceM;
    }

    static int insertionMerge(int N, int M, int i, int j) {
        int allOnes = ~0;
        int leftMask = allOnes << j + 1;
        int rightMask = (1 << i) - 1;
        int mask = leftMask | rightMask;
        int Ni2jSet0 = N & mask;
        int MLeftShiftI = M << i;
        int NReplaceM = Ni2jSet0 | MLeftShiftI;
        return NReplaceM;
    }
}
