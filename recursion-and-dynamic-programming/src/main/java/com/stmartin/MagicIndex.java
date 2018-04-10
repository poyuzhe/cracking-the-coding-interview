package com.stmartin;

/*
Magic Index: A magic index in an array A [0 ... n-1] is defined to be an index such that A[i] =
i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
array A.
FOLLOW UP
What if the values are not distinct?
Hints: # 170, #204, #240, #286, #340
 */
class MagicIndex {
    static Integer findMagicIndexInDistinctArray(int[] A) {
        // recursively compare the middle element's index and value of a sub array, if index is bigger, go to
        // the right half, if index is smaller, go to the left half. if the index equals the value, return that index.
        // if there's nothing to iterate, return null.
        return checkMiddleIndex(A, 0, A.length - 1);
    }

    static Integer findMagicIndexInNonDistinctArray(int[] A) {
        return checkMiddleIndexNonDistinct(A, 0, A.length - 1);
    }

    private static Integer checkMiddleIndex(int[] intArray, int startIndex, int endIndex) {
        if (intArray == null || startIndex < 0 || endIndex >= intArray.length) {
            return null;
        }
        if (startIndex > endIndex) {
            return null;
        }
        int middleIndex = (endIndex + startIndex) / 2;
        if (middleIndex == intArray[middleIndex]) {
            return middleIndex;
        }
        if (middleIndex > intArray[middleIndex]) {
            return checkMiddleIndex(intArray, middleIndex + 1, endIndex);
        }
        return checkMiddleIndex(intArray, startIndex, middleIndex - 1);
    }

    private static Integer checkMiddleIndexNonDistinct(int[] intArray, int startIndex, int endIndex) {
        if (intArray == null || startIndex < 0 || endIndex >= intArray.length) {
            return null;
        }
        if (startIndex > endIndex) {
            return null;
        }
        int middleIndex = (endIndex + startIndex) / 2;
        if (middleIndex == intArray[middleIndex]) {
            return middleIndex;
        }
        Integer result = checkMiddleIndexNonDistinct(intArray, Math.max(intArray[middleIndex], middleIndex + 1), endIndex);
        if (result == null) {
            result = checkMiddleIndexNonDistinct(intArray, startIndex, Math.min(intArray[middleIndex], middleIndex - 1));
        }
        return result;
    }
}
