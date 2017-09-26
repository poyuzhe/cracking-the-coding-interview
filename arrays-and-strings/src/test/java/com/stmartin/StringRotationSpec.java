package com.stmartin;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.stmartin.StringRotation.*;

/**
 * Created by shentong on 2017/9/26.
 * spec:
 * 1. two string as input
 * 2. if any of the input string is null, then not rotation of each other
 * 3. if there exists an index in s2 that when take the substring before the index and append it to the end of the string,
 * the two strings are equal, then the two strings are rotations of each other
 * 4. there is a method isSubstring which can only be called once
 */
public class StringRotationSpec {
    String str1 = "waterbottle";
    String str2 = "erbottlewat";

    @Test
    public void whenNullThenNotRotation() {
        assertEquals(isRotation(null, null), false);
    }

    @Test
    public void whenNotEqualLengthThenNotRotation() {
        assertEquals(isRotation(str1, str1+"a"),false);
    }

    @Test
    public void whenRotationThenRotation() {
        assertEquals(isRotation(str1, str2), true);
    }

    @Test
    public void whenNullThenNotRotationSubstring() {
        assertEquals(isRotationSubstring(null, null), false);
    }

    @Test
    public void whenNotEqualLengthThenNotRotationSubstring() {
        assertEquals(isRotationSubstring(str1, str1+"a"),false);
    }

    @Test
    public void whenRotationThenRotationSubstring() {
        assertEquals(isRotationSubstring(str1, str2), true);
    }
}
