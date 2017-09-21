package com.stmartin;

/**
 * Created by shentong on 2017/9/21.
 * Write a method to replace all spaces in a string with '%20': You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 */
class URLify {
    //time complexity: O(N)
    static String urlify(String str, int length) {
        if (str == null) {
            return null;
        }
        if (length == 0) {
            return "";
        }
        char[] charArray = str.toCharArray();
        int afterIndex = charArray.length;
        int beforeIndex = length - 1;
        while (beforeIndex >= 0) {
            char realChar = charArray[beforeIndex];
            if (realChar == ' ') {
                charArray[--afterIndex] = '0';
                charArray[--afterIndex] = '2';
                charArray[--afterIndex] = '%';
            } else {
                charArray[--afterIndex] = realChar;
            }
            beforeIndex--;
        }
        return new String(charArray);
    }
}
