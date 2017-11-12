package com.stmartin;

/**
 * Check Subtree: Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
 algorithm to determine if T2 is a subtree of Tl .
 A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
 That is, if you cut off the tree at node n, the two trees would be identical.
 Hints: #4, #11, #18, #31, #37
*/
class CheckSubtree {
    //time complexity is O(n + km)
    static boolean isSubtree(BinaryTreeNode T1, BinaryTreeNode T2) {
        return T1 != null && T2 != null && (checkIdentical(T1, T2) || isSubtree(T1.leftChild, T2) || isSubtree(T1.rightChild, T2));
    }

    static private boolean checkIdentical(BinaryTreeNode T1, BinaryTreeNode T2) {
        return (T1 == null && T2 == null) ||
                (T1 != null && T2 != null && T1.name == T2.name
                        && checkIdentical(T1.leftChild, T2.leftChild) && checkIdentical(T1.rightChild, T2.rightChild));
    }

    //time complexity is O(n+m), space complexity is O(n+m)
    static boolean isSubtreeTraversal(BinaryTreeNode T1, BinaryTreeNode T2) {
        if (T1 == null || T2 == null) {
            return false;
        }
        String T1Traversal = getPreOrderTraversalString(T1);
        String T2Traversal = getPreOrderTraversalString(T2);
        return T1Traversal.contains(T2Traversal);
    }

    static private String getPreOrderTraversalString(BinaryTreeNode root) {
        StringBuilder result = new StringBuilder();
        result.append(root.name);
        visitChild(root.leftChild, result);
        visitChild(root.rightChild, result);
        return result.toString();
    }

    static private void visitChild(BinaryTreeNode child, StringBuilder stringBuilder) {
        if (child == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(child.name);
            visitChild(child.leftChild, stringBuilder);
            visitChild(child.rightChild, stringBuilder);
        }
    }
}
