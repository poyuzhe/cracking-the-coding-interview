package com.stmartin;

/**
 * Created by shentong on 2017/9/26.
 * String Rotation: Assume you have a method isSubstring which checks if one word is a substring
 of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 call to isSubstring (e . g. , "waterbottle " is a rotation of " erbottlewat").
 Hints: #34, #88, #104
 */
class StringRotation {
    static boolean isSubstring(String str1, String str2) {
        return str1 != null && str2 != null && str2.contains(str1);
    }

    //time complexity: O(n)
    static boolean isRotationSubstring(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        return isSubstring(str1, str2 + str2);
    }

    //time complexity: O(n)
    static boolean isRotation(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        int splitIndex = -1;
        int str2Index = 0;
        int str1Index = 0;
        while(str2Index < str2.length()) {
            if (splitIndex == -1 && str1.codePointAt(str1Index) == str2.codePointAt(str2Index)) {
                splitIndex = str2Index;
                str1Index++;
            } else if (splitIndex != -1){
                if (str1.codePointAt(str1Index) != str2.codePointAt(str2Index)){
                    splitIndex = -1;
                    str1Index = 0;
                } else {
                    str1Index++;
                }
            }
            str2Index++;
        }
        if (splitIndex == -1) {
            return false;
        }
        return str2.substring(0, splitIndex).equals(str1.substring(str1.length() - splitIndex));
    }
}
