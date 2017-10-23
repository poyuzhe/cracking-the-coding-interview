package com.stmartin;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.stmartin.ValidateBST.*;

/**
 * Created by shentong on 2017/10/23.
 * spec:
 * 1. input is a binary tree node.
 * 2. output is a boolean value checking whether the binary tree is a binary search tree.
 */
public class ValidateBSTSpec {
    private BinaryTreeNode binarySearchTreeRoot;
    private BinaryTreeNode nonBinarySearchTreeRoot;
    @Before
    public void setUp() {
        binarySearchTreeRoot = new BinaryTreeNode(5);
        binarySearchTreeRoot.leftChild = new BinaryTreeNode(2);
        binarySearchTreeRoot.rightChild = new BinaryTreeNode(7);
        binarySearchTreeRoot.leftChild.leftChild = new BinaryTreeNode(1);
        binarySearchTreeRoot.leftChild.rightChild = new BinaryTreeNode(4);
        binarySearchTreeRoot.rightChild.leftChild = new BinaryTreeNode(6);
        binarySearchTreeRoot.rightChild.rightChild = new BinaryTreeNode(8);

        nonBinarySearchTreeRoot = new BinaryTreeNode(4);
        nonBinarySearchTreeRoot.leftChild = new BinaryTreeNode(2);
        nonBinarySearchTreeRoot.rightChild = new BinaryTreeNode(7);
        nonBinarySearchTreeRoot.leftChild.leftChild = new BinaryTreeNode(1);
        nonBinarySearchTreeRoot.leftChild.leftChild.leftChild = new BinaryTreeNode(5);
        nonBinarySearchTreeRoot.rightChild.leftChild = new BinaryTreeNode(6);
        nonBinarySearchTreeRoot.rightChild.rightChild = new BinaryTreeNode(8);
    }

    @Test
    public void whenBSTThenTrue() {
        assertTrue(isBinarySearchTree(binarySearchTreeRoot));
    }

    @Test
    public void whenNotBSTThenFalse() {
        assertFalse(isBinarySearchTree(nonBinarySearchTreeRoot));
    }

    @Test
    public void whenBSTThenTrueRange() {
        assertTrue(isBinarySearchTreeRange(binarySearchTreeRoot));
    }

    @Test
    public void whenNotBSTThenFalseRange() {
        assertFalse(isBinarySearchTreeRange(nonBinarySearchTreeRoot));
    }

    @Test
    public void whenBSTThenTrueMinMax() {
        assertTrue(isBinarySearchTreeMinMax(binarySearchTreeRoot));
    }

    @Test
    public void whenNotBSTThenFalseMinMax() {
        assertFalse(isBinarySearchTreeMinMax(nonBinarySearchTreeRoot));
    }
}
