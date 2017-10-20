package com.stmartin;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.stmartin.MinimalTree.*;

/**
 * Created by shentong on 2017/10/20.
 * Spec:
 * 1. input is a sorted int array with strict ascending order.
 * 2. output is a BinaryTreeNode which is the root of a binary search tree whose elements are the elements of the input
 * array, and this binary search tree's height is of the minimal possible value.
 */
public class MinimalTreeSpec {
    private int[] sortedArray = {1,2,3,4,5,6,7,8,9};

    @Before
    public void setUp() {
    }

    @Test
    public void testHeightMinimal() {
        BinaryTreeNode root = createMinimalTree(sortedArray, 0, 8);
        assertEquals(root.heightBelow(), 4);
    }

    @Test
    public void testResultBinarySearchTree() {
        BinaryTreeNode root = createMinimalTree(sortedArray, 0, 8);
        assertTrue(root.isBinarySearchTree());
    }
}
