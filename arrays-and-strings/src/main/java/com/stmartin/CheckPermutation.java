package com.stmartin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shentong on 2017/9/20.
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 */
class CheckPermutation {
    //time complexity: O(N)
    static boolean checkPermutation(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Integer, Integer> characterFrequency = new HashMap<>();
        str1.codePoints().boxed().forEach(integer -> characterFrequency.merge(integer, 1, Integer::sum));
        str2.codePoints().boxed().forEach(integer -> characterFrequency.merge(integer, -1, Integer::sum));
        return characterFrequency.values().stream().noneMatch(integer -> integer != 0);
    }

    //time complexity: O(N*N)
    static boolean checkPermutationNoDataStructure(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            int index = str2.indexOf(ch);
            if (index == -1) {
                return false;
            }
            str2 = str2.replaceFirst(String.valueOf(ch), "");
        }
        return true;
    }

    //time complexity: O(N*logN)
    static boolean checkPermutationSort(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        int codePointCount = str1.codePointCount(0, str1.length());
        if (codePointCount != str2.codePointCount(0, str2.length())) {
            return false;
        }
        String sortedStr1 = new String(str1.codePoints().sorted().toArray(), 0, codePointCount);
        String sortedStr2 = new String(str2.codePoints().sorted().toArray(), 0, codePointCount);
        return sortedStr1.equals(sortedStr2);
    }
}
