package com.stmartin;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.stmartin.FirstCommonAncestor.*;

/**
 * Created by shentong on 2017/11/9.
 * Spec:
 * 1. input is two node from the same binary tree.
 * 2. output is the first common ancestor of these two binary tree nodes. if the two nodes are identical, then the
 * first common ancestor is itself.
 * 3. cannot use additional data structure to store nodes.
 * 4. node does not have a reference to its parent.
 */
public class FirstCommonAncestorSpec {
    private BinaryTreeNode node1;
    private BinaryTreeNode node2;
    private BinaryTreeNode root;
    private BinaryTreeNode commonAncestor;

    @Before
    public void setUp() {
        node1 = new BinaryTreeNode(1);
        node2 = new BinaryTreeNode(2);
        commonAncestor = new BinaryTreeNode(0);
        root = new BinaryTreeNode(10);
        root.leftChild = commonAncestor;
        commonAncestor.leftChild = node1;
        commonAncestor.rightChild = new BinaryTreeNode(11);
        commonAncestor.rightChild.leftChild = node2;
    }

    @Test
    public void testCommonAncestor() {
        assertEquals(commonAncestor, findFirstCommonAncestor(root, node1, node2));
    }
}
