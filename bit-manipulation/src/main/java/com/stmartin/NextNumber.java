package com.stmartin;

/**
 * Created by shentong on 2017/11/20.
 * Next Number: Given a positive integer, print the next smallest and the next largest number that
 have the same number of 1 bits in their binary representation.
 Hints : #147 , #175, #242, #312, #339, #358, #375, #390
 */
class NextNumber {
    static int nextSmallestInt(int positiveValue) {
        int oneBitsCount = countOneBits(positiveValue);
        int anotherOneBitsCount = -1;
        while (anotherOneBitsCount != oneBitsCount) {
            positiveValue++;
            anotherOneBitsCount = countOneBits(positiveValue);
        }
        return positiveValue;
    }

    static int nextLargestInt(int positiveValue) {
        int oneBitsCount = countOneBits(positiveValue);
        int anotherOneBitsCount = -1;
        while (anotherOneBitsCount != oneBitsCount) {
            positiveValue--;
            anotherOneBitsCount = countOneBits(positiveValue);
        }
        return positiveValue;
    }

    static int nextSmallestIntEfficient(int positiveValue) {
        int firstNonTrailingZeroIndex = findFirstNonTrailingZero(positiveValue);
        int oneBeforeCount = countTotalOnesUntil(positiveValue, firstNonTrailingZeroIndex) - 1;
        int result = positiveValue | (1 << firstNonTrailingZeroIndex);
        result = result & (-1 << firstNonTrailingZeroIndex);
        result = result | ~(-1 << oneBeforeCount);
        return result;
    }

    static int nextLargestIntEfficient(int positiveValue) {
        int firstNonTrailingOneIndex = findFirstNonTrailingOne(positiveValue);
        int zeroBeforeCount = countTotalZeroesUntil(positiveValue, firstNonTrailingOneIndex) - 1;
        int result = positiveValue & ~(1 << firstNonTrailingOneIndex);
        result = result | ~(-1 << firstNonTrailingOneIndex );
        result = result & (-1 << zeroBeforeCount);
        return result;
    }

    private static int countOneBits(int input) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int iBit = input & (1 << i);
            if (iBit != 0) {
                count++;
            }
        }
        return count;
    }

    private static int countTotalOnesUntil(int input, int index) {
        int count = 0;
        for (int i = 0; i < index; i++) {
            int iBit = input & (1 << i);
            if (iBit != 0) {
                count++;
            }
        }
        return count;
    }

    private static int countTotalZeroesUntil(int input, int index) {
        int count = 0;
        for (int i = 0; i < index; i++) {
            int iBit = input & (1 << i);
            if (iBit == 0) {
                count++;
            }
        }
        return count;
    }

    private static int findFirstNonTrailingZero(int input) {
        boolean foundOne = false;
        for (int i = 0; i < 32; i++) {
            int iBit = input & (1 << i);
            if (foundOne && iBit == 0) {
                return i;
            }
            if (!foundOne && iBit != 0) {
                foundOne = true;
            }
        }
        return -1;
    }

    private static int findFirstNonTrailingOne(int input) {
        boolean foundOne = false;
        for (int i = 0; i < 32; i++) {
            int iBit = input & (1 << i);
            if (foundOne && iBit != 0) {
                return i;
            }
            if (!foundOne && iBit == 0) {
                foundOne = true;
            }
        }
        return -1;
    }
}
