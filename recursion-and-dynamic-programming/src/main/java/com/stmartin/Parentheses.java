package com.stmartin;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
Parens: Implement an algorithm to print all valid (e.g ., properly opened and closed) combinations
of n pairs of parentheses.
EXAMPLE
Input: 3
Output: ((())), (()()), (())(), ()(()), ()()()
Hints : # 138, #174, #187, #209 , #243 , #265, #295
 */
class Parentheses {
    static Set<String> findAllValidCombinationsOfParentheses(int numberOfPairs) {
        if (numberOfPairs == 1) {
            Set<String> result = new HashSet<>();
            result.add("()");
            return result;
        }

        Set<String> previous = findAllValidCombinationsOfParentheses(numberOfPairs - 1);
        Set<String> full = new HashSet<>();
        previous.forEach(s -> {
            full.add("()" + s);
            full.add(s + "()");
            full.add("(" + s + ")");
        });
        return full;
    }

    static Set<String> findAllValidCombinationsOfParenthesesByStep(int pairs) {
        Set<ParenthesisStep> result = findAllValidCombinationsOfParenthesesByParenthesisStep(pairs * 2, pairs);
        return result != null ? result.stream().map(ParenthesisStep::getRepresentation).collect(Collectors.toSet()) : null;
    }

    private static Set<ParenthesisStep> findAllValidCombinationsOfParenthesesByParenthesisStep(int step, int max) {
        if (step == 1) {
            Set<ParenthesisStep> result = new HashSet<>();
            result.add(ParenthesisStep.initialFirstHalf());
            return result;
        }
        Set<ParenthesisStep> previous = findAllValidCombinationsOfParenthesesByParenthesisStep(step - 1, max);
        Set<ParenthesisStep> full = new HashSet<>();
        previous.forEach(parenthesisStep -> {
            if (parenthesisStep.canAddFirstHalf(max)) {
                full.add(parenthesisStep.addFirstHalf());
            }
            if (parenthesisStep.canAddSecondHalf()) {
                full.add(parenthesisStep.addSecondHalf());
            }
        });
        return full;
    }

    static class ParenthesisStep {
        private String representation;
        private int firstHalfCount;
        private int secondHalfCount;

        static ParenthesisStep initialFirstHalf() {
            ParenthesisStep initial = new ParenthesisStep();
            initial.representation = "(";
            initial.firstHalfCount = 1;
            initial.secondHalfCount = 0;
            return initial;
        }

        ParenthesisStep addFirstHalf() {
            ParenthesisStep newStep = new ParenthesisStep();
            newStep.representation = this.representation + "(";
            newStep.firstHalfCount = this.firstHalfCount + 1;
            newStep.secondHalfCount = this.secondHalfCount;
            return newStep;
        }

        ParenthesisStep addSecondHalf() {
            ParenthesisStep newStep = new ParenthesisStep();
            newStep.representation = this.representation + ")";
            newStep.firstHalfCount = this.firstHalfCount;
            newStep.secondHalfCount = this.secondHalfCount + 1;
            return newStep;
        }

        boolean canAddFirstHalf(int max) {
            return this.firstHalfCount < max;
        }

        boolean canAddSecondHalf() {
            return this.secondHalfCount < this.firstHalfCount;
        }

        String getRepresentation() {
            return representation;
        }
    }
}
