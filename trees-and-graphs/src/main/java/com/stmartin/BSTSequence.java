package com.stmartin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shentong on 2017/11/9.
 * BST Sequences: A binary search tree was created by traversing through an array from left to right
 and inserting each element. Given a binary search tree with distinct elements, print all possible
 arrays that could have led to this tree.
 EXAMPLE
 Input: 1 <-- 2 --> 3
 Output: {2, 1, 3} , {2, 3, 1}
 Hints: # 39 , # 48 , # 66 , # 82
 */
class BSTSequence {
    static List<int[]> findBSTSequences(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        List<int[]> leftSequences = findBSTSequences(root.leftChild);
        List<int[]> rightSequences = findBSTSequences(root.rightChild);
        List<int[]> thisSequences = new ArrayList<>();
        if (leftSequences == null && rightSequences == null) {
            int[] thisSequence = new int[]{root.name};
            thisSequences.add(thisSequence);
            return thisSequences;
        }
        if (leftSequences == null || rightSequences == null) {
            List<int[]> nonNullSequences = leftSequences == null ? rightSequences : leftSequences;
            for (int[] sequence : nonNullSequences) {
                int[] thisSequence = new int[sequence.length + 1];
                thisSequence[0] = root.name;
                System.arraycopy(sequence, 0, thisSequence, 1, sequence.length);
                thisSequences.add(thisSequence);
            }
            return thisSequences;
        }
        for (int[] leftSequence : leftSequences) {
            for (int[] rightSequence : rightSequences) {
                List<int[]> childSequences = generateSequences(leftSequence, rightSequence);
                for (int[] childSequence : childSequences) {
                    int[] thisSequence = new int[childSequence.length + 1];
                    thisSequence[0] = root.name;
                    System.arraycopy(childSequence, 0, thisSequence, 1, childSequence.length);
                    thisSequences.add(thisSequence);
                }
            }
        }
        return thisSequences;
    }

    private static List<int[]> generateSequences(int[] sequence1, int[] sequence2) {
        List<int[]> result = new ArrayList<>();
        if (sequence1 == null || sequence1.length == 0) {
            result.add(sequence2);
            return result;
        }
        if (sequence2 == null || sequence2.length == 0) {
            result.add(sequence1);
            return result;
        }
        List<int[]> sequence1First = generateSequences(Arrays.copyOfRange(sequence1, 1, sequence1.length), sequence2);
        List<int[]> sequence2First = generateSequences(sequence1, Arrays.copyOfRange(sequence2, 1, sequence2.length));
        for (int[] sequence : sequence1First) {
            int[] newSequence = new int[sequence.length + 1];
            newSequence[0] = sequence1[0];
            System.arraycopy(sequence, 0, newSequence, 1, sequence.length);
            result.add(newSequence);
        }
        for (int[] sequence : sequence2First) {
            int[] newSequence = new int[sequence.length + 1];
            newSequence[0] = sequence2[0];
            System.arraycopy(sequence, 0, newSequence, 1, sequence.length);
            result.add(newSequence);
        }
        return result;
    }
}
