package com.stmartin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.stmartin.PathsWithSum.*;

/**
 * Created by shentong on 2017/11/14.
 * Spec:
 * 1. input is the root node of a Binary tree whose nodes' value are integers, as well as a integer value as the second
 * argument.
 * 2. output is the number of paths within which all nodes sum to the given particular value.
 * 3. a path travels downwards within the tree, but not necessarily starts from the root or ends with the leaf.
 */
public class PathsWithPathSpec {
    private BinaryTreeNode root;

    @Before
    public void setUp() {
        root = new BinaryTreeNode(5);
        root.leftChild = new BinaryTreeNode(3);
        root.rightChild = new BinaryTreeNode(7);
        root.leftChild.leftChild = new BinaryTreeNode(4);
        root.leftChild.rightChild = new BinaryTreeNode(8);
        root.rightChild.leftChild = new BinaryTreeNode(6);
        root.rightChild.rightChild = new BinaryTreeNode(4);
    }

    @Test
    public void countPathToSumSpec() {
        assertEquals(countPathsToSum(root, 11), 2);
        assertEquals(countPathsToSum(root, 12), 2);
    }

    @Test
    public void countPathToSumOptimized() {
        assertEquals(countPathsToSumOptimized(root, 11), 2);
        assertEquals(countPathsToSumOptimized(root, 12), 2);
    }
}
