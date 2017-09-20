package com.stmartin;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by shentong on 2017/9/20.
 * Spec: given 2 strings, if the two strings have the same length, do not equal, and have exactly
 * the same character frequency, then they are considered each other's permutation.
 */
public class CheckPermutationSpec {
    @Test
    public void whenTwoStringsNotSameLengthNotPermutation() {
        String str1 = "helloWorld";
        String str2 = "helloNewWorld";
        assertFalse(CheckPermutation.checkPermutation(str1, str2));
    }

    @Test
    public void whenTwoStringNullNotPermutation() {
        String str1 = "helloWorld";
        String str2 = null;
        assertFalse(CheckPermutation.checkPermutation(str1, str2));
    }

    @Test
    public void whenTwoStringSameCharacterFrequencyIsPermutation() {
        String str1 = "helloWorld";
        String str2 = "Worldhello";
        assertTrue(CheckPermutation.checkPermutation(str1, str2));
    }

    @Test
    public void whenTwoStringNotSameCharacterFrequencyNotPermutation() {
        String str1 = "helloWorld";
        String str2 = "Wordyhello";
        assertFalse(CheckPermutation.checkPermutation(str1, str2));
    }

    @Test
    public void whenTwoStringsNotSameLengthNotPermutationNoDataStructure() {
        String str1 = "helloWorld";
        String str2 = "helloNewWorld";
        assertFalse(CheckPermutation.checkPermutationNoDataStructure(str1, str2));
    }

    @Test
    public void whenTwoStringNullNotPermutationNoDataStructure() {
        String str1 = "helloWorld";
        String str2 = null;
        assertFalse(CheckPermutation.checkPermutationNoDataStructure(str1, str2));
    }

    @Test
    public void whenTwoStringSameCharacterFrequencyIsPermutationNoDataStructure() {
        String str1 = "helloWorld";
        String str2 = "Worldhello";
        assertTrue(CheckPermutation.checkPermutationNoDataStructure(str1, str2));
    }

    @Test
    public void whenTwoStringNotSameCharacterFrequencyNotPermutationNoDataStructure() {
        String str1 = "helloWorld";
        String str2 = "Wordyhello";
        assertFalse(CheckPermutation.checkPermutationNoDataStructure(str1, str2));
    }

    @Test
    public void whenTwoStringsNotSameLengthNotPermutationSort() {
        String str1 = "helloWorld";
        String str2 = "helloNewWorld";
        assertFalse(CheckPermutation.checkPermutationSort(str1, str2));
    }

    @Test
    public void whenTwoStringNullNotPermutationSort() {
        String str1 = "helloWorld";
        String str2 = null;
        assertFalse(CheckPermutation.checkPermutationSort(str1, str2));
    }

    @Test
    public void whenTwoStringSameCharacterFrequencyIsPermutationSort() {
        String str1 = "helloWorld";
        String str2 = "Worldhello";
        assertTrue(CheckPermutation.checkPermutationSort(str1, str2));
    }

    @Test
    public void whenTwoStringNotSameCharacterFrequencyNotPermutationSort() {
        String str1 = "helloWorld";
        String str2 = "Wordyhello";
        assertFalse(CheckPermutation.checkPermutationSort(str1, str2));
    }

    @Test
    public void benchmarkCheckPermutationHashTable() {
        for (int i = 0; i < 1000000; i++) {
            whenTwoStringSameCharacterFrequencyIsPermutation();
            whenTwoStringNotSameCharacterFrequencyNotPermutation();
        }
    }

    @Test
    public void benchmarkCheckPermutationNoDataStructure() {
        for (int i = 0; i < 1000000; i++) {
            whenTwoStringSameCharacterFrequencyIsPermutationNoDataStructure();
            whenTwoStringNotSameCharacterFrequencyNotPermutationNoDataStructure();
        }
    }

    @Test
    public void benchmarkCheckPermutationSort() {
        for (int i = 0; i < 1000000; i++) {
            whenTwoStringSameCharacterFrequencyIsPermutationSort();
            whenTwoStringNotSameCharacterFrequencyNotPermutationSort();
        }
    }
}
