package com.stmartin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.stmartin.CheckSubtree.*;

/**
 * Spec:
 * 1. input is two Binary Trees.
 * 2. output is to check whether one binary tree is a subtree of the other binary tree.
 */
public class CheckSubtreeSpec {
    private BinaryTreeNode T1;
    private BinaryTreeNode T2;
    private BinaryTreeNode T3;

    @Before
    public void setUp() {
        T1 = new BinaryTreeNode(5);
        T1.leftChild = new BinaryTreeNode(3);
        T1.rightChild = new BinaryTreeNode(7);
        T1.leftChild.leftChild = new BinaryTreeNode(1);
        T1.leftChild.rightChild = new BinaryTreeNode(4);
        T1.rightChild.leftChild = new BinaryTreeNode(6);
        T1.rightChild.rightChild = new BinaryTreeNode(8);

        T2 = new BinaryTreeNode(3);
        T2.leftChild = new BinaryTreeNode(1);
        T2.rightChild = new BinaryTreeNode(4);

        T3 = new BinaryTreeNode(3);
        T3.leftChild = new BinaryTreeNode(2);
        T3.rightChild = new BinaryTreeNode(4);
    }

    @Test
    public void whenIsSubtreeThenTrue() {
        assertTrue(isSubtree(T1, T2));
    }

    @Test
    public void whenNotSubtreeThenFalse() {
        assertFalse(isSubtree(T1, T3));
    }

    @Test
    public void whenIsSubTreeThenTrueTraversal() {
        assertTrue(isSubtreeTraversal(T1, T2));
    }

    @Test
    public void whenNotSubtreeThenFalseTraversal() {
        assertFalse(isSubtreeTraversal(T1, T3));
    }
}
