package com.stmartin;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;
import static com.stmartin.ListOfDepths.*;

/**
 * Created by shentong on 2017/10/20.
 * Spec:
 * 1. input is a binary tree.
 * 2. output is a list of LinkedList, where each LinkedList contains elements of a particular depth of the original tree.
 */
public class ListOfDepthsSpec {
    private BinaryTreeNode root;

    @Before
    public void setUp() {
        root = new BinaryTreeNode(5);
        root.leftChild = new BinaryTreeNode(2);
        root.rightChild = new BinaryTreeNode(7);
        root.leftChild.leftChild = new BinaryTreeNode(1);
        root.leftChild.rightChild = new BinaryTreeNode(3);
        root.rightChild.leftChild = new BinaryTreeNode(6);
        root.rightChild.rightChild = new BinaryTreeNode(8);
    }

    @Test
    public void whenNormalReturnListOfLinkedList() {
        List<LinkedList<BinaryTreeNode>> result = createListOfDepths(root);
        assertEquals(result.size(), 3);
        assertEquals(result.get(0).getFirst().name, 5);
        assertEquals(result.get(0).getLast().name, 5);
        assertEquals(result.get(1).getFirst().name, 2);
        assertEquals(result.get(1).getLast().name, 7);
        assertEquals(result.get(2).getFirst().name, 1);
        assertEquals(result.get(2).getLast().name, 8);
    }
}
