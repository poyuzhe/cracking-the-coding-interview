package com.stmartin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shentong on 2017/11/13.
 * Spec:
 * 1. the binary tree's node has a reference to its parent.
 * 2. the binary tree stores the count of total elements in a property.
 * 3. the binary tree stores the current level.
 * 4. the binary tree stores the count of element of the current level.
 */
public class RandomNodeBinaryTreeSpec {
    private RandomNodeBinaryTree tree;
    private BinaryTreeNode root;
    private BinaryTreeNode nodeToOperateOn;

    @Before
    public void setUp() {
        tree = new RandomNodeBinaryTree();
        root = new BinaryTreeNode(5);
        nodeToOperateOn = new BinaryTreeNode(6);
        tree.root = root;
        root.leftChild = new BinaryTreeNode(3);
        root.leftChild.parent = root;
        root.rightChild = new BinaryTreeNode(7);
        root.rightChild.parent = root;
        root.leftChild.leftChild = new BinaryTreeNode(1);
        root.leftChild.leftChild.parent = root.leftChild;
        root.leftChild.rightChild = new BinaryTreeNode(4);
        root.leftChild.rightChild.parent = root.leftChild;
        root.rightChild.leftChild = nodeToOperateOn;
        nodeToOperateOn.parent = root.rightChild;
        root.rightChild.rightChild = new BinaryTreeNode(8);
        root.rightChild.rightChild.parent = root.rightChild;
    }

    @Test
    public void findSpec() {
        assertEquals(tree.find(nodeToOperateOn.name), nodeToOperateOn);
    }

    @Test
    public void countSpec() {
        assertEquals(tree.getCount(), 7);
    }

    @Test
    public void insertSpec() {
        BinaryTreeNode node = new BinaryTreeNode(0);
        tree.insert(node);
        assertEquals(tree.getCount(), 8);
        assertEquals(tree.getLastNode(), node);
    }

    @Test
    public void deleteSpec() {
        tree.delete(nodeToOperateOn);
        assertEquals(tree.getCount(), 6);
        assertEquals(tree.getLastNode().name, 8);
    }

    @Test
    public void randomNodeSpec() {
        //calculate a random int between 0 and count, k
        //depth first search, find and return the kth element
    }
}
