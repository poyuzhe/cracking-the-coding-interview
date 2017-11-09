package com.stmartin;

/**
 * Created by shentong on 2017/11/9.
 * First Common Ancestor: Design an algorithm and write code to find the first common ancestor
 of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE : This is not
 necessarily a binary search tree.
 Hints: # 10 , #16, # 28 , #36, # 46 , # 70 , #80, #96
 */
class FirstCommonAncestor {
    static BinaryTreeNode findFirstCommonAncestor(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
        // do a depth first search from the root.
        // if found node1 or node2, return a result marking the node found in the recursive call.
        // the first node where both node1 and node2 is found is the first common ancestor.
        if (node1 == node2) {
            return node1;
        }
        if (root == node1 || root == node2) {
            return root;
        }
        return depthFirstSearch(root, node1, node2).firstCommonAncestor;
    }

    static private class RecursiveResult {
        BinaryTreeNode firstCommonAncestor;
        boolean foundNode1;
        boolean foundNode2;

        RecursiveResult(BinaryTreeNode firstCommonAncestor, boolean foundNode1, boolean foundNode2) {
            this.firstCommonAncestor = firstCommonAncestor;
            this.foundNode1 = foundNode1;
            this.foundNode2 = foundNode2;
        }
    }

    static private RecursiveResult depthFirstSearch(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
        if (root == null) {
            return new RecursiveResult(null, false, false);
        }
        RecursiveResult leftResult = depthFirstSearch(root.leftChild, node1, node2);
        if (leftResult.firstCommonAncestor != null) {
            return leftResult;
        }
        RecursiveResult rightResult = depthFirstSearch(root.rightChild, node1, node2);
        if (rightResult.firstCommonAncestor != null) {
            return rightResult;
        }
        boolean foundNode1 = leftResult.foundNode1 || rightResult.foundNode1 || root == node1;
        boolean foundNode2 = leftResult.foundNode2 || rightResult.foundNode2 || root == node2;
        return new RecursiveResult(foundNode1 && foundNode2 ? root : null, foundNode1, foundNode2);
    }
}
