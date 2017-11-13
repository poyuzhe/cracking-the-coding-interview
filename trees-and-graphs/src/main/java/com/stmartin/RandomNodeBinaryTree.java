package com.stmartin;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by shentong on 2017/11/13.
 * Random Node: You are implementing a binary tree class from scratch which, in addition to
 insert, find, and delete, has a method getRandomNode() which returns a random node
 from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
 for getRandomNode, and explain how you would implement the rest of the methods.
 Hints: #42, #54, #62, #75, #89, #99, #112 , #119
 */
class RandomNodeBinaryTree {
    BinaryTreeNode root;
    private Integer count = null;
    private Integer currentLevel = null;
    private Integer currentLevelCount = null;
    private BinaryTreeNode lastNode = null;
    private BinaryTreeNode firstNodeForCurrentLevel = null;
    private BinaryTreeNode lastNodeForPreviousLevel = null;

    int getCount() {
        if (count == null) {
            getCurrentLevel();
        }
        return count;
    }

    private int getCurrentLevel() {
        if (currentLevel == null) {
            Queue<BinaryTreeNode> queue = new LinkedBlockingQueue<>();
            queue.add(root);
            int level = 1;
            int elementCount = 0;
            int count = 0;
            BinaryTreeNode lastNode = null;
            BinaryTreeNode firstNodeForCurrentLevel = null;
            BinaryTreeNode lastNodeForPreviousLevel = null;
            while (queue.size() > 0) {
                BinaryTreeNode node = queue.remove();
                elementCount++;
                count++;
                if (elementCount > Math.pow(2, level - 1)){
                    level++;
                    firstNodeForCurrentLevel = node;
                    lastNodeForPreviousLevel = lastNode;
                }
                lastNode = node;
                if (node.leftChild != null) {
                    queue.add(node.leftChild);
                }
                if (node.rightChild != null) {
                    queue.add(node.rightChild);
                }
            }
            this.currentLevel = level;
            this.currentLevelCount = elementCount - (int)Math.pow(2, level - 1);
            this.lastNode = lastNode;
            this.firstNodeForCurrentLevel = firstNodeForCurrentLevel;
            this.count = count;
            this.lastNodeForPreviousLevel = lastNodeForPreviousLevel;
        }
        return this.currentLevel;
    }

    private int getCurrentLevelCount() {
        if (this.currentLevelCount == null) {
            getCurrentLevel();
        }
        return this.currentLevelCount;
    }

    BinaryTreeNode getLastNode() {
        if (this.lastNode == null) {
            getCurrentLevel();
        }
        return this.lastNode;
    }

    private BinaryTreeNode getFirstNodeForCurrentLevel() {
        if (this.firstNodeForCurrentLevel == null) {
            getCurrentLevel();
        }
        return this.firstNodeForCurrentLevel;
    }

    private BinaryTreeNode getLastNodeForPreviousLevel() {
        if (this.lastNodeForPreviousLevel == null) {
            getCurrentLevel();
        }
        return this.lastNodeForPreviousLevel;
    }

    BinaryTreeNode find(int valueToFind) {
        return find(root, valueToFind);
    }

    private BinaryTreeNode find(BinaryTreeNode subNode, int valueToFind) {
        if (subNode == null) {
            return null;
        }
        if (subNode.name == valueToFind) {
            return subNode;
        }
        BinaryTreeNode result = find(subNode.leftChild, valueToFind);
        if (result == null) {
            result = find(subNode.rightChild, valueToFind);
        }
        return result;
    }

    void insert(BinaryTreeNode node) {
        BinaryTreeNode lastNode = getLastNode();
        int currentLevel = getCurrentLevel();
        int currentLevelCount = getCurrentLevelCount();
        BinaryTreeNode firstNodeForCurrentLevel = getFirstNodeForCurrentLevel();

        boolean isLevelFull = currentLevelCount == Math.pow(2, currentLevel - 1);
        if (isLevelFull) {
            firstNodeForCurrentLevel.leftChild = node;
            node.parent = firstNodeForCurrentLevel;
            this.lastNode = node;
            this.firstNodeForCurrentLevel = node;
            this.currentLevel = currentLevel + 1;
            this.currentLevelCount = 1;
            this.lastNodeForPreviousLevel = lastNode;
        } else {
            if (lastNode.parent.leftChild == lastNode) {
                lastNode.parent.rightChild = node;
                node.parent = lastNode.parent;
                this.lastNode = node;
                this.currentLevelCount++;
            } else {
                BinaryTreeNode parent = lastNode.parent;
                int upLevel = 1;
                while (parent.parent != null && parent.parent.leftChild != parent) {
                    parent = parent.parent;
                    upLevel++;
                }
                parent = parent.rightChild;
                upLevel--;
                while (upLevel > 1) {
                    parent = parent.leftChild;
                    upLevel--;
                }
                parent.leftChild = node;
                node.parent = parent;
                this.lastNode = node;
                this.currentLevelCount++;
            }
        }
        this.count++;
    }

    void delete(BinaryTreeNode node) {
        BinaryTreeNode lastNode = getLastNode();
        if (node != lastNode) {
            if (lastNode.parent.leftChild == lastNode) {
                lastNode.parent.leftChild = null;
            } else {
                lastNode.parent.rightChild = null;
            }
            lastNode.parent = node.parent;
            lastNode.leftChild = node.leftChild;
            lastNode.rightChild = node.rightChild;
            if (node.leftChild != null) {
                node.leftChild.parent = lastNode;
            }
            if (node.rightChild != null) {
                node.rightChild.parent = lastNode;
            }
        }
        this.count--;
        this.currentLevelCount--;
        if (this.currentLevelCount == 0) {
            this.currentLevel--;
            this.currentLevelCount = (int)Math.pow(2, this.currentLevel - 1);
            this.lastNode = this.lastNodeForPreviousLevel;
            this.lastNodeForPreviousLevel = this.lastNodeForPreviousLevel == null ? null : this.lastNodeForPreviousLevel.parent;
            if (this.lastNode == null) {
                this.firstNodeForCurrentLevel = null;
            } else {
                int currentLevel = this.currentLevel - 1;
                BinaryTreeNode parent = this.lastNode.parent;
                if (parent != null) {
                    while (currentLevel >= 1) {
                        if (parent.parent == null) {
                            break;
                        }
                        parent = parent.parent;
                        currentLevel--;
                    }
                    while (currentLevel < this.currentLevel) {
                        parent = parent.leftChild;
                        currentLevel++;
                    }
                    this.firstNodeForCurrentLevel = parent.leftChild;
                } else {
                    this.firstNodeForCurrentLevel = this.lastNode;
                }
            }
        } else {
            //todo: find the next left element.
        }

        node.parent = null;
        node.leftChild = null;
        node.rightChild = null;
    }
}
