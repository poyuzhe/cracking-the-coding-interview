package com.stmartin;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shentong on 2017/9/20.
 * class to judge is a given string contain all unique characters
 */
class StringUniqueJudge {

    //time complexity: O(n)?
    static boolean judgeUnique(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        long totalCharacters = str.codePoints().count();
        long uniqueCharacters = str.codePoints().distinct().count();
        return totalCharacters == uniqueCharacters;
    }

    //time complexity: O(n)
    static boolean judgeUniqueWithHashTable(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        Map<Integer, Integer> hashTable = new HashMap<>();
        str.codePoints().boxed().forEach(integer -> {
            Integer oldCount = hashTable.get(integer);
            if (oldCount == null) {
                hashTable.put(integer, 1);
            } else {
                hashTable.put(Integer.MIN_VALUE, 1);
            }
        });
        return !hashTable.containsKey(Integer.MIN_VALUE);
    }

    // time complexity: O(n)
    static boolean judgeOnlyEnglishLowercaseCharacterUnique(String str) {
        if (str.length() > 26) {
            return false;
        }

        BitSet result = new BitSet(26);
        for (int i = 0; i < result.length(); i++) {
            result.clear(i);
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int index = ch % 26;
            if (result.get(index)) {
                return false;
            }
            result.set(index);
        }

        return true;
    }

    //time complexity: O(n)
    static boolean judgeOnlyEnglishLowercaseCharacterUniqueBitwise(String str) {
        if (str.length() > 26) {
            return false;
        }

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) % 26;
            if ((checker & (1 << index)) > 0) {
                return false;
            }
            checker |= 1 << index;
        }
        return true;
    }
}
