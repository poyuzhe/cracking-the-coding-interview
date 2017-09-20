package com.stmartin;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by shentong on 2017/9/20.
 * Spec: write an algorithm to determine if a string contains all unique characters.
 * Sub-spec 1: can use additional data structures.
 * Sub-spec 2: cannot use additional data structures.
 */
public class JudgeStringUniqueSpec {
    @Test
    public void whenUniqueStringThenJudgeUnique() {
        String str1 = "abcdefghijklmnopqrstuvwxyz";
        assertTrue(StringUniqueJudge.judgeUnique(str1));
    }

    @Test
    public void whenNotUniqueStringThenJudgeNonUnique() {
        String str1 = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        assertFalse(StringUniqueJudge.judgeUnique(str1));
    }

    @Test
    public void whenUniqueStringThenJudgeUniqueWithHashTable() {
        String string = "abcdefghijklmnopqrstuvwxyz";
        assertTrue(StringUniqueJudge.judgeUniqueWithHashTable(string));
    }

    @Test
    public void whenNotUniqueStringThenJudgeNonUniqueWithHashTable() {
        String string = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        assertFalse(StringUniqueJudge.judgeUniqueWithHashTable(string));
    }

    @Test
    public void whenOnlyEnglishLowercaseCharacterInStringThenJudgeUniqueTrue() {
        String string = "abcdefghijklmnopqrstuvwxyz";
        assertTrue(StringUniqueJudge.judgeOnlyEnglishLowercaseCharacterUnique(string));
    }

    @Test
    public void whenOnlyEnglishLowercaseCharacterInStringThenJudgeNonUniqueFalse() {
        String string = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        assertFalse(StringUniqueJudge.judgeOnlyEnglishLowercaseCharacterUnique(string));
    }

    @Test
    public void whenOnlyEnglishLowercaseCharacterInStringThenJudgeUniqueTrueWithNoOtherDataStructure() {
        String string = "abcdefghijklmnopqrstuvwxyz";
        assertTrue(StringUniqueJudge.judgeOnlyEnglishLowercaseCharacterUniqueBitwise(string));
    }

    @Test
    public void whenOnlyEnglishLowercaseCharacterInStringThenJudgeNonUniqueFalseWithNoOtherDataStructure() {
        String string = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        assertFalse(StringUniqueJudge.judgeOnlyEnglishLowercaseCharacterUniqueBitwise(string));
    }

    @Test
    public void benchmarkJudgeUnique() {
        for (int i = 0; i < 100000; i++) {
            whenUniqueStringThenJudgeUnique();
        }
    }

    @Test
    public void benchmarkJudgeUniqueHashTable() {
        for (int i = 0; i < 100000; i++) {
            whenUniqueStringThenJudgeUniqueWithHashTable();
        }
    }

    @Test
    public void benchmarkJudgeUniqueBitSet() {
        for (int i = 0; i < 100000; i++) {
            whenOnlyEnglishLowercaseCharacterInStringThenJudgeUniqueTrue();
        }
    }

    @Test
    public void benchmarkJudgeUniqueBitWise() {
        for (int i = 0; i < 100000; i++) {
            whenOnlyEnglishLowercaseCharacterInStringThenJudgeUniqueTrueWithNoOtherDataStructure();
        }
    }

    @Test
    public void benchmarkJudgeNonUnique() {
        for (int i = 0; i < 100000; i++) {
            whenUniqueStringThenJudgeUnique();
        }
    }

    @Test
    public void benchmarkJudgeNonUniqueHashTable() {
        for (int i = 0; i < 100000; i++) {
            whenUniqueStringThenJudgeUniqueWithHashTable();
        }
    }

    @Test
    public void benchmarkJudgeNonUniqueBitSet() {
        for (int i = 0; i < 100000; i++) {
            whenOnlyEnglishLowercaseCharacterInStringThenJudgeUniqueTrue();
        }
    }

    @Test
    public void benchmarkJudgeNonUniqueBitWise() {
        for (int i = 0; i < 100000; i++) {
            whenOnlyEnglishLowercaseCharacterInStringThenJudgeUniqueTrueWithNoOtherDataStructure();
        }
    }
}
