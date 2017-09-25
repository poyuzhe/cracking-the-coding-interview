package com.stmartin;

/**
 * Created by shentong on 2017/9/25.
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 * Hints: #92, # 110
 */
class StringCompression {
    //time complexity: O(n)
    static String compress(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return str;
        }
        char[] compressed = new char[str.length()];
        int index = 0;
        int compressedIndex = -2;
        char currentChar = '0';
        while(index < str.length()) {
            char c = str.charAt(index);
            if (c != currentChar) {
                if (compressedIndex + 3 >= str.length() - 1) {
                    return str;
                }
                currentChar = c;
                compressedIndex += 2;
                compressed[compressedIndex] = c;
                compressed[compressedIndex + 1] = '1';
            } else if (c == compressed[compressedIndex]) {
                compressed[compressedIndex + 1] += 1;
            }
            index++;
        }
        return new String(compressed).trim();
    }
}
