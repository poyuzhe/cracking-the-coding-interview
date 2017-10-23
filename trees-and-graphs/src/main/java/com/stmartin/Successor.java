package com.stmartin;

/**
 * Created by shentong on 2017/10/23.
 * Successor: Write an algorithm to find the "next" node (i .e ., in-order successor ) of a given node in a
 binary search tree. You may assume that each node has a link to its parent.
 */
class Successor {
    static BinaryTreeNode getSuccessor(BinaryTreeNode node) {
        if (node.rightChild == null) {
            int value = node.name;
            while (node.parent != null && node.parent.name < value) {
                node = node.parent;
            }
            return node.parent;
        } else {
            node = node.rightChild;
            while (node.leftChild != null) {
                node = node.leftChild;
            }
            return node;
        }
    }
}
