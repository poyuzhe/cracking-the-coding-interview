package com.stmartin;

import java.util.HashSet;
import java.util.Set;

/*
Permutations without Dups: Write a method to compute all permutations of a string of unique
characters.
Hints: # 150, #185, #200, #267, #278, #309, #335, #356
 */
class PermutationsWithoutDups {
    static Set<String> findAllPermutationsOfUniqueString(String unique) {
        if (unique == null || unique.isEmpty()) {
            return null;
        }
        Set<String> minusOneSet = findAllPermutationsOfUniqueString(unique.substring(0, unique.length() - 1));
        char lastChar = unique.charAt(unique.length() - 1);
        Set<String> fullSet = new HashSet<>();
        if (minusOneSet == null || minusOneSet.isEmpty()) {
            fullSet.add(lastChar + "");
        } else {
            minusOneSet.forEach(s -> {
                for (int index = 0; index <= s.length(); index++) {
                    fullSet.add(s.substring(0, index) + lastChar + (index < s.length() ? s.substring(index, s.length()) : ""));
                }
            });
        }
        return fullSet;
    }
}
