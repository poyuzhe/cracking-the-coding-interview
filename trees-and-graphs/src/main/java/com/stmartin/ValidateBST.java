package com.stmartin;

/**
 * Created by shentong on 2017/10/23.
 * Validate 8ST: Implement a function to check if a binary tree is a binary search tree.
 */
class ValidateBST {
    static boolean isBinarySearchTree(BinaryTreeNode root) {
        return root.isBinarySearchTree();
    }

    static boolean isBinarySearchTreeRange(BinaryTreeNode root) {
        return isBinarySearchTreeRecursive(root).isBST;
    }

    private static BinarySearchTreeCheck isBinarySearchTreeRecursive(BinaryTreeNode root) {
        if (root == null) {
            return new BinarySearchTreeCheck(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        BinarySearchTreeCheck leftCheck = isBinarySearchTreeRecursive(root.leftChild);
        BinarySearchTreeCheck rightCheck = isBinarySearchTreeRecursive(root.rightChild);
        boolean isBST = leftCheck.isBST && rightCheck.isBST && leftCheck.subTreeMax <= root.name && root.name < rightCheck.subTreeMin;
        int subTreeMax = Math.max(root.name, Math.max(leftCheck.subTreeMax, rightCheck.subTreeMax));
        int subTreeMin = Math.min(root.name, Math.min(leftCheck.subTreeMin, rightCheck.subTreeMin));
        return new BinarySearchTreeCheck(isBST, subTreeMax, subTreeMin);
    }

    static private class BinarySearchTreeCheck {
        boolean isBST;
        int subTreeMin;
        int subTreeMax;

        BinarySearchTreeCheck(boolean isBST, int subTreeMax, int subTreeMin) {
            this.isBST = isBST;
            this.subTreeMax = subTreeMax;
            this.subTreeMin = subTreeMin;
        }
    }

    static boolean isBinarySearchTreeMinMax(BinaryTreeNode root) {
        return isBinarySearchTreeMinMax(root, null, null);
    }

    private static boolean isBinarySearchTreeMinMax(BinaryTreeNode root, Integer minLimit, Integer maxLimit) {
        if (root == null) {
            return true;
        }
        if (minLimit != null && root.name < minLimit) {
            return false;
        }
        if (maxLimit != null && root.name >= maxLimit) {
            return false;
        }
        return isBinarySearchTreeMinMax(root.leftChild, minLimit, root.name) && isBinarySearchTreeMinMax(root.rightChild, root.name, maxLimit);
    }
}