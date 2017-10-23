package com.stmartin;

import java.util.List;

/**
 * Created by shentong on 2017/10/20.
 */
public class BinaryTreeNode {
    public int name;
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;
    public BinaryTreeNode parent;
    int level;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int name) {
        this.name = name;
    }

    public BinaryTreeNode(int name, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.name = name;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int heightBelow() {
        return 1 + Math.max(leftChild != null ? leftChild.heightBelow() : 0, rightChild != null ? rightChild.heightBelow() : 0);
    }

    public int getMaxSubTreeValue() {
        if (leftChild == null && rightChild == null) {
            return name;
        }
        return Math.max(this.name, Math.max(leftChild == null ? Integer.MIN_VALUE : leftChild.getMaxSubTreeValue(),
                rightChild == null ? Integer.MIN_VALUE : rightChild.getMaxSubTreeValue()));
    }

    public int getMinSubTreeValue() {
        if (leftChild == null && rightChild == null) {
            return name;
        }
        return Math.min(this.name, Math.min(leftChild == null ? Integer.MAX_VALUE : leftChild.getMinSubTreeValue(),
                rightChild == null ? Integer.MAX_VALUE : rightChild.getMinSubTreeValue()));
    }

    public boolean isBinarySearchTree() {
        return (leftChild == null || (leftChild.getMaxSubTreeValue() <= this.name && leftChild.isBinarySearchTree())) &&
                (rightChild == null || (rightChild.getMinSubTreeValue() > this.name && rightChild.isBinarySearchTree()));
    }

    public BalancedResult isBalanced() {
        if (leftChild == null && rightChild == null) {
            return new BalancedResult(true, 1);
        }
        BalancedResult leftBalance = leftChild == null ? new BalancedResult(true, 0) :
                leftChild.isBalanced();
        BalancedResult rightBalance = rightChild == null ? new BalancedResult(true, 0) :
                rightChild.isBalanced();

        boolean isBalanced = leftBalance.isBalanced && rightBalance.isBalanced
                && Math.abs(leftBalance.height - rightBalance.height) <= 1;
        return new BalancedResult(isBalanced, Math.max(leftBalance.height, rightBalance.height) + 1);
    }

    static class BalancedResult {
        boolean isBalanced;
        int height;

        BalancedResult(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
