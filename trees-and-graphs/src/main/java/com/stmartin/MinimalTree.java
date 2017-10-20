package com.stmartin;

/**
 * Created by shentong on 2017/10/20.
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
 algorithm to create a binary search tree with minimal height.
 */
class MinimalTree {
    static BinaryTreeNode createMinimalTree(int[] sortedArray, int first, int last) {
        if (sortedArray == null || sortedArray.length == 0) {
            return null;
        }
        if (last < first) {
            return null;
        }
        int rootIndex = (first + last) / 2;
        BinaryTreeNode root = new BinaryTreeNode(rootIndex);
        root.leftChild = createMinimalTree(sortedArray, first, rootIndex - 1);
        root.rightChild = createMinimalTree(sortedArray, rootIndex + 1, last);
        return root;
    }
}
