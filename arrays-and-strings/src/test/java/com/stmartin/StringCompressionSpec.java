package com.stmartin;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.stmartin.StringCompression.*;

/**
 * Created by shentong on 2017/9/25.
 * Spec:
 * 1. input string consists only of uppercase and lowercase characters.
 * 2. compressed string is of the format: character1[count1]character2[count2]...characterN[countN]
 * 3. if the compressed string of not shorter than the original, return the original.
 * 4. the null input string compressed to null output string
 */
public class StringCompressionSpec {
    String longString = "aaabbbcdd";
    String shortString = "abcccddd";
    String longCompressed = "a3b3c1d2";

    @Test
    public void whenNullInputThenNullOutput() {
        assertEquals(compress(null), null);
    }

    @Test
    public void whenEmptyInputThenSameOutput() {
        assertEquals(compress(""), "");
    }

    @Test
    public void whenLongStringThenCompressedString() {
        assertEquals(compress(longString), longCompressed);
    }

    @Test
    public void whenShortStringThenOriginal() {
        assertEquals(compress(shortString), shortString);
    }
}
