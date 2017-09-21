package com.stmartin;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by shentong on 2017/9/21.
 * Spec: replace space in string with '%20'. The input String has sufficient space at the end to hold the additional
 * characters. The length of the string minus the trailing spaces is given as a parameter.
 */
public class URLifySpec {
    @Test
    public void whenLengthIsZeroAndStringNotNullReturnEmptyString() {
        assertEquals("", URLify.urlify("     ",0));
    }

    @Test
    public void whenStringIsNullReturnNull() {
        assertEquals(null, URLify.urlify(null, 0));
    }

    @Test
    public void whenStringNotNullAndLengthBiggerThanZeroThenReplaceSpace() {
        assertEquals("%20jesus%20christ", URLify.urlify(" jesus christ    ", 13));
    }
}
