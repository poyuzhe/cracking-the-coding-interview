package com.stmartin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.stmartin.BinaryToString.*;

/**
 * Created by shentong on 2017/11/17.
 * Spec:
 * 1. input is a real number between 0 and 1, which is a double.
 * 2. output is the binary representation of the input number as a string. If the binary cannot be accurately represented
 * within 32 characters, return "ERROR:".
 */
public class BinaryToStringSpec {
    private double accurateNum;
    private double inaccurateNum;
    private String accurateBinaryString;
    private String errorString;

    @Before
    public void setUp() {
        accurateNum = 0.125;
        inaccurateNum = 0.1;
        accurateBinaryString = "0.001";
        errorString = "ERROR:";
    }

    @Test
    public void whenAccurateThenOutputBinaryString() {
        assertEquals(accurateBinaryString, binaryToString(accurateNum));
    }

    @Test
    public void whenInaccurateThenOutputError() {
        assertEquals(errorString, binaryToString(inaccurateNum));
    }
}
