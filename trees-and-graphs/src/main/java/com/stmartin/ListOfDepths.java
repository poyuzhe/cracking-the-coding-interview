package com.stmartin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by shentong on 2017/10/20.
 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
 at each depth (e .g ., if you have a tree with depth D, you ' ll have D linked lists).
 */
class ListOfDepths {
    static List<LinkedList<BinaryTreeNode>> createListOfDepths(BinaryTreeNode root) {
        List<LinkedList<BinaryTreeNode>> result = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedBlockingQueue<>();
        root.level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.remove();
            if (current.level >= result.size()) {
                result.add(new LinkedList<>());
            }
            result.get(current.level).add(current);
            if (current.leftChild != null) {
                current.leftChild.level = current.level + 1;
                queue.add(current.leftChild);
            }
            if (current.rightChild != null) {
                current.rightChild.level= current.level + 1;
                queue.add(current.rightChild);
            }
        }
        return result;
    }
}
