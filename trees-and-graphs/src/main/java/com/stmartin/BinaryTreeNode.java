package com.stmartin;

import java.util.List;

/**
 * Created by shentong on 2017/10/20.
 */
public class BinaryTreeNode {
    public int name;
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;
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
        return Math.max(leftChild == null ? 0 : leftChild.getMaxSubTreeValue(), rightChild == null ? 0 : rightChild.getMaxSubTreeValue());
    }

    public boolean isBinarySearchTree() {
        return (leftChild == null || (leftChild.getMaxSubTreeValue() <= this.name && leftChild.isBinarySearchTree())) &&
                (rightChild == null || (rightChild.getMaxSubTreeValue() > this.name && rightChild.isBinarySearchTree()));
    }
}
