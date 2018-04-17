package com.stmartin;

import java.util.HashSet;
import java.util.Set;

/*
Permutations with Dups: Write a method to compute all permutations of a string whose charac-
ters are not necessarily unique. The list of permutations should not have duplicates.
Hints: #161, #190, #222, #255
 */
class PermutationsWithDups {
    static Set<String> findPermutationsWithDups(String original) {
        if (original == null || original.isEmpty()) {
            return null;
        }
        Set<String> minusOneSet = findPermutationsWithDups(original.substring(0, original.length() - 1));
        Set<String> fullSet = new HashSet<>();
        char lastChar = original.charAt(original.length() - 1);
        if (minusOneSet == null || minusOneSet.isEmpty()) {
            fullSet.add(lastChar + "");
        } else {
            minusOneSet.forEach(s -> {
                for (int index = 0; index <= s.length(); index++) {
                    if (index == 0 || s.charAt(index - 1) != lastChar) {
                        fullSet.add(s.substring(0, index) + lastChar + (index < s.length() ? s.substring(index, s.length()) : ""));
                    }
                }
            });
        }
        return fullSet;
    }
}
