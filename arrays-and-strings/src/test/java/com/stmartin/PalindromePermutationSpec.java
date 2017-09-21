package com.stmartin;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by shentong on 2017/9/21.
 * spec: given a string, ignore any spaces in it, check to see if its character's count is all even or at most one odd.
 */
public class PalindromePermutationSpec {
    private String allEvenString;
    private String oneOddString;
    private String moreOddString;

    @Before
    public void setUp() {
        allEvenString = "ttooiiee ";
        Random random = new Random();
        char[] randomOdd = new char[random.nextInt(10) * 2 + 1];
        Arrays.fill(randomOdd, 's');
        oneOddString = allEvenString + new String(randomOdd);
        moreOddString = oneOddString + "xbq";
    }

    @Test
    public void whenNullOrEmptyTrimmedStringNotPalindromePermutation() {
        assertFalse(PalindromePermutation.palindromePermutation(null));
        assertFalse(PalindromePermutation.palindromePermutation(" "));
    }

    @Test
    public void whenAllEvenIsPalindromePermutation() {
        assertTrue(PalindromePermutation.palindromePermutation(allEvenString));
    }

    @Test
    public void whenOneOddIsPalindromePermutation() {
        assertTrue(PalindromePermutation.palindromePermutation(oneOddString));
    }

    @Test
    public void whenMoreThanOneOddNotPalindromePermutation() {
        assertFalse(PalindromePermutation.palindromePermutation(moreOddString));
    }

    @Test
    public void whenNullOrEmptyTrimmedStringNotPalindromePermutationAdHoc() {
        assertFalse(PalindromePermutation.palindromePermutationAdHoc(null));
        assertFalse(PalindromePermutation.palindromePermutationAdHoc(" "));
    }

    @Test
    public void whenAllEvenIsPalindromePermutationAdHoc() {
        assertTrue(PalindromePermutation.palindromePermutationAdHoc(allEvenString));
    }

    @Test
    public void whenOneOddIsPalindromePermutationAdHoc() {
        assertTrue(PalindromePermutation.palindromePermutationAdHoc(oneOddString));
    }

    @Test
    public void whenMoreThanOneOddNotPalindromePermutationAdHoc() {
        assertFalse(PalindromePermutation.palindromePermutationAdHoc(moreOddString));
    }

    @Test
    public void whenNullOrEmptyTrimmedStringNotPalindromePermutationBitVector() {
        assertFalse(PalindromePermutation.palindromePermutationBitVector(null));
        assertFalse(PalindromePermutation.palindromePermutationBitVector(" "));
    }

    @Test
    public void whenAllEvenIsPalindromePermutationBitVector() {
        assertTrue(PalindromePermutation.palindromePermutationBitVector(allEvenString));
    }

    @Test
    public void whenOneOddIsPalindromePermutationBitVector() {
        assertTrue(PalindromePermutation.palindromePermutationBitVector(oneOddString));
    }

    @Test
    public void whenMoreThanOneOddNotPalindromePermutationBitVector() {
        assertFalse(PalindromePermutation.palindromePermutationBitVector(moreOddString));
    }

    @Test
    public void whenNullOrEmptyTrimmedStringNotPalindromePermutationNoDataStructure() {
        assertFalse(PalindromePermutation.palindromePermutationNoDataStructure(null));
        assertFalse(PalindromePermutation.palindromePermutationNoDataStructure(" "));
    }

    @Test
    public void whenAllEvenIsPalindromePermutationNoDataStructure() {
        assertTrue(PalindromePermutation.palindromePermutationNoDataStructure(allEvenString));
    }

    @Test
    public void whenOneOddIsPalindromePermutationNoDataStructure() {
        assertTrue(PalindromePermutation.palindromePermutationNoDataStructure(oneOddString));
    }

    @Test
    public void whenMoreThanOneOddNotPalindromePermutationNoDataStructure() {
        assertFalse(PalindromePermutation.palindromePermutationNoDataStructure(moreOddString));
    }
}
