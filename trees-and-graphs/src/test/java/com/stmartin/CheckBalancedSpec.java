package com.stmartin;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.stmartin.CheckBalanced.*;

/**
 * Created by shentong on 2017/10/23.
 * Spec:
 * 1. input is a binary tree.
 * 2. output is to check if the binary tree is balanced.
 * 3. definition of balanced: height difference of two children is at most 1. 
 */
public class CheckBalancedSpec {
    private BinaryTreeNode balancedTreeRoot;
    private BinaryTreeNode nonBalancedTreeRoot;

    @Before
    public void setUp() {
        balancedTreeRoot = new BinaryTreeNode(5);
        balancedTreeRoot.leftChild = new BinaryTreeNode(2);
        balancedTreeRoot.rightChild = new BinaryTreeNode(7);
        balancedTreeRoot.leftChild.leftChild = new BinaryTreeNode(1);
        balancedTreeRoot.leftChild.rightChild = new BinaryTreeNode(3);

        nonBalancedTreeRoot = new BinaryTreeNode(4);
        nonBalancedTreeRoot.leftChild = new BinaryTreeNode(2);
        nonBalancedTreeRoot.rightChild = new BinaryTreeNode(7);
        nonBalancedTreeRoot.leftChild.leftChild = new BinaryTreeNode(1);
        nonBalancedTreeRoot.leftChild.leftChild.leftChild = new BinaryTreeNode(5);
    }

    @Test
    public void whenBalancedThenBalanced() {
        assertTrue(isBalanced(balancedTreeRoot));
    }

    @Test
    public void whenNotBalancedThenNotBalanced() {
        assertFalse(isBalanced(nonBalancedTreeRoot));
    }
}
