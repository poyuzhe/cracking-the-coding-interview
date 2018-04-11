package com.stmartin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Power Set: Write a method to return all subsets of a set.
Hints: #273, #290, #338, #354, #373
 */
class PowerSet {
    static List<Set<Integer>> getSubsets(Set<Integer> fullSet) {
        // iterate through all elements of the set, put this element in a new set and put this new set into result.
        // for each element, iterate through all sets in the result list, make a copy of it and add the new element.
        final List<Set<Integer>> result = new ArrayList<>();
        fullSet.forEach(i -> {
            if (result.size() > 0) {
                List<Set<Integer>> tempList = new ArrayList<>();
                result.forEach(set -> {
                    Set<Integer> newSet = new HashSet<>(set);
                    newSet.add(i);
                    tempList.add(newSet);
                });
                result.addAll(tempList);
            }
            Set<Integer> thisSet = new HashSet<>();
            thisSet.add(i);
            result.add(thisSet);
        });
        return result;
    }
}
