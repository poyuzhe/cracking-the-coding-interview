package com.stmartin;

import jdk.nashorn.internal.runtime.BitVector;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shentong on 2017/9/21.
 *  Given a string, write a function to check if it is a permutation of a palindrome.
 *  A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 *  is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 *  EXAMPLE
 *  Input: Tact Coa
 *  Output: True (permutations: "taco cat". "atco cta". etc.)
 */
class PalindromePermutation {
    //time complexity: O(n)
    static boolean palindromePermutation(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        Map<Integer, Integer> frequencyMap = new HashMap<>(str.length() * 2);
        str.codePoints().filter(i -> !Character.isWhitespace(i)).boxed()
                .forEach(integer -> frequencyMap.merge(integer, 1, Integer::sum));
        return frequencyMap.keySet().stream()
                .filter(integer -> frequencyMap.get(integer) % 2 == 1)
                .count() <= 1;
    }

    //assume the ASCII charset
    //time complexity: O(n)
    static boolean palindromePermutationBitVector(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        BitVector bitVector = new BitVector(128);
        bitVector.clearAll();
        str.chars().forEach(bitVector::toggle);
        int oddCharCount = 0;
        for (int i = 0; i < 128; i++) {
            if (Character.isSpaceChar((char)i)) {
                continue;
            }
            if (bitVector.isSet(i)) {
                oddCharCount++;
            }
        }
        return oddCharCount <= 1;
    }

    //time complexity: O(n)
    static boolean palindromePermutationAdHoc(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        int[] codePoints = str.codePoints().sorted().toArray();
        int oddCharCount = 0;
        int index = 0;
        while (index < codePoints.length) {
            if (Character.isWhitespace(codePoints[index])) {
                index++;
                continue;
            }
            int codePoint = codePoints[index];
            int thisCount = 1;
            index++;
            while(index < codePoints.length && codePoints[index] == codePoint) {
                thisCount++;
                index++;
            }
            if (thisCount % 2 == 1) {
                oddCharCount++;
            }
        }
        return oddCharCount <= 1;
    }

    //assume ASCII char set
    static boolean palindromePermutationNoDataStructure(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }

        int checker = 0;
        int oddCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isWhitespace(ch)) {
                continue;
            }
            int index = ch % 128;
            checker ^= 1 << index;
            if ((checker & 1 << index) >> index == 1) {
                oddCount++;
            } else {
                oddCount--;
            }
        }

        return oddCount <= 1;
    }
}
