package com.stmartin;

/**
 * Created by shentong on 2017/11/22.
 * Conversion: Write a function to determine the number of bits you would need to flip to convert
 integer A to integer B.
 EXAMPLE
 Input: 29 (or: 111131), 15 (or: 131111)
 Output: 2
 Hints: #336, #369
 */
class Conversion {
    static int countBitsToFlip(int a, int b) {
        int count = 0;
        for (int i = a ^ b; i != 0; i = i & (i - 1)) {
            count++;
        }
        return count;
    }
}
