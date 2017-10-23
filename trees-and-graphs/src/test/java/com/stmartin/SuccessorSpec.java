package com.stmartin;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.stmartin.Successor.*;


/**
 * Created by shentong on 2017/10/23.
 * Spec:
 * 1. input is a given node in a Binary Search Tree, not necessarily the root.
 * 2. output is another node in the same Binary Search Tree that is the next node during an in-order traversal.
 * 3. each node has a link to its parent.
 */
public class SuccessorSpec {
    private BinaryTreeNode binarySearchTreeRoot;
    @Before
    public void setUp() {
        binarySearchTreeRoot = new BinaryTreeNode(5);
        binarySearchTreeRoot.leftChild = new BinaryTreeNode(2);
        binarySearchTreeRoot.leftChild.parent = binarySearchTreeRoot;
        binarySearchTreeRoot.rightChild = new BinaryTreeNode(7);
        binarySearchTreeRoot.rightChild.parent = binarySearchTreeRoot;
        binarySearchTreeRoot.leftChild.leftChild = new BinaryTreeNode(1);
        binarySearchTreeRoot.leftChild.leftChild.parent = binarySearchTreeRoot.leftChild;
        binarySearchTreeRoot.leftChild.rightChild = new BinaryTreeNode(4);
        binarySearchTreeRoot.leftChild.rightChild.parent = binarySearchTreeRoot.leftChild;
        binarySearchTreeRoot.rightChild.leftChild = new BinaryTreeNode(6);
        binarySearchTreeRoot.rightChild.leftChild.parent = binarySearchTreeRoot.rightChild;
        binarySearchTreeRoot.rightChild.rightChild = new BinaryTreeNode(8);
        binarySearchTreeRoot.rightChild.rightChild.parent = binarySearchTreeRoot.rightChild;
    }

    @Test
    public void testSuccessor() {
        assertEquals(getSuccessor(binarySearchTreeRoot), binarySearchTreeRoot.rightChild.leftChild);
        assertEquals(getSuccessor(binarySearchTreeRoot.leftChild), binarySearchTreeRoot.leftChild.rightChild);
        assertEquals(getSuccessor(binarySearchTreeRoot.rightChild), binarySearchTreeRoot.rightChild.rightChild);
        assertEquals(getSuccessor(binarySearchTreeRoot.rightChild.rightChild), null);
    }
}
