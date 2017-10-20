package com.stmartin;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by shentong on 2017/10/20.
 */
public class BinaryTreeNodeSpec {
    BinaryTreeNode binarySearchTreeRoot;
    BinaryTreeNode nonBinarySearchTreeRoot;
    @Before
    public void setUp() {
        binarySearchTreeRoot = new BinaryTreeNode(5);
        binarySearchTreeRoot.leftChild = new BinaryTreeNode(2);
        binarySearchTreeRoot.rightChild = new BinaryTreeNode(7);
        binarySearchTreeRoot.leftChild.leftChild = new BinaryTreeNode(1);
        binarySearchTreeRoot.leftChild.rightChild = new BinaryTreeNode(3);
        binarySearchTreeRoot.rightChild.leftChild = new BinaryTreeNode(6);
        binarySearchTreeRoot.rightChild.rightChild = new BinaryTreeNode(8);

        nonBinarySearchTreeRoot = new BinaryTreeNode(4);
        nonBinarySearchTreeRoot.leftChild = new BinaryTreeNode(2);
        nonBinarySearchTreeRoot.rightChild = new BinaryTreeNode(7);
        nonBinarySearchTreeRoot.leftChild.leftChild = new BinaryTreeNode(1);
        nonBinarySearchTreeRoot.leftChild.rightChild = new BinaryTreeNode(5);
        nonBinarySearchTreeRoot.rightChild.leftChild = new BinaryTreeNode(6);
        nonBinarySearchTreeRoot.rightChild.rightChild = new BinaryTreeNode(8);
    }

    @Test
    public void testHeightBelow() {
        assertEquals(3, binarySearchTreeRoot.heightBelow());
        assertEquals(3, nonBinarySearchTreeRoot.heightBelow());
    }

    @Test
    public void testMaxSubtreeValue() {
        assertEquals(8, binarySearchTreeRoot.getMaxSubTreeValue());
    }

    @Test
    public void testIsBinarySearchTree() {
        assertTrue(binarySearchTreeRoot.isBinarySearchTree());
        assertFalse(nonBinarySearchTreeRoot.isBinarySearchTree());
    }
}
