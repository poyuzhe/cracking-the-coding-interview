package com.stmartin;

import org.omg.SendingContext.RunTime;

/**
 * Created by shentong on 2017/9/21.
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, pIe -> true
 * pales. pale -> true
 * pale. bale -> true
 * pale. bake -> false
 */
class OneAway {
    //time complexity: O(n)
    static boolean oneAway(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        int length1 = str1.codePointCount(0, str1.length());
        int length2 = str2.codePointCount(0, str2.length());
        if (Math.abs(length1 - length2) > 1) {
            return false;
        }
        String s1 = length1 >= length2 ? str1 : str2;
        String s2 = length1 >= length2 ? str2 : str1;
        int str1Index = 0;
        int str2Index = 0;
        boolean foundDifference = false;
        while (str1Index < s1.length() && str2Index < s2.length()) {
            char ch1 = s1.charAt(str1Index);
            char ch2 = s2.charAt(str2Index);
            if (ch1 == ch2) {
                if (Character.isHighSurrogate(ch1)) {
                    char nextCh1 = s1.charAt(str1Index + 1);
                    char nextCh2 = s2.charAt(str2Index + 1);
                    if (nextCh1 != nextCh2) {
                        if (foundDifference) {
                            return false;
                        }
                        foundDifference = true;
                        if (length1 == length2) {
                            str2Index += 2;
                        }
                    }
                    str1Index += 2;
                } else {
                    str1Index++;
                    str2Index++;
                }
            } else {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                if (length1 == length2) {
                    str2Index += Character.isHighSurrogate(ch2) ? 2 : 1;
                }
                str1Index += Character.isHighSurrogate(ch1) ? 2 : 1;
            }
        }
        return true;
    }

    //time complexity: O(n)
    static boolean oneAwayHighLevel(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        int length1 = str1.codePointCount(0, str1.length());
        int length2 = str2.codePointCount(0, str2.length());
        if (Math.abs(length1 - length2) > 1) {
            return false;
        }
        if (str1.equals(str2)) {
            return true;
        }
        String s1 = length1 >= length2 ? str1 : str2;
        String s2 = length1 >= length2 ? str2 : str1;
        int chIndex = 0;
        while (chIndex < s2.length()) {
            if (s1.charAt(chIndex) != s2.charAt(chIndex)) {
               break;
            }
            chIndex++;
        }
        if (length1 == length2) {
            s2 = s2.substring(0, chIndex) +
                    s1.substring(chIndex, chIndex + (Character.isHighSurrogate(s1.charAt(chIndex)) ? 2 : 1)) +
                    s2.substring(chIndex + (Character.isHighSurrogate(s2.charAt(chIndex)) ? 2 : 1));
        } else {
            s2 = s2.substring(0, chIndex) +
                    s1.substring(chIndex, chIndex + (Character.isHighSurrogate(s1.charAt(chIndex)) ? 2 : 1)) +
                    s2.substring(chIndex);
        }
        return s1.equals(s2);
    }
}
