package com.stmartin;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by shentong on 2017/11/14.
 * Paths with Sum: You are given a binary tree in which each node contains an integer value (which
 might be positive or negative). Design an algorithm to count the number of paths that sum to a
 given value. The path does not need to start or end at the root or a leaf, but it must go downwards
 (traveling only from parent nodes to child nodes).
 Hints: #6, #14, #52, #68, #77, #87, #94, #103, #108, #115
 */
class PathsWithSum {
    static int countPathsToSum(BinaryTreeNode root, int sum) {
        AtomicInteger count = new AtomicInteger(0);
        Queue<BinaryTreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (queue.size() > 0) {
            BinaryTreeNode node = queue.remove();
            countPathsToSumStartingWithNode(node, 0, sum, count);
            if (node.leftChild != null) {
                queue.add(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.add(node.rightChild);
            }
        }
        return count.get();
    }

    private static void countPathsToSumStartingWithNode(BinaryTreeNode node, int currentSum, int sum, AtomicInteger count) {
        if (node != null) {
            currentSum = currentSum + node.name;
            if (currentSum == sum) {
                count.incrementAndGet();
            }
            if (node.leftChild != null) {
                countPathsToSumStartingWithNode(node.leftChild, currentSum, sum, count);
            }
            if (node.rightChild != null) {
                countPathsToSumStartingWithNode(node.rightChild, currentSum, sum, count);
            }
        }
    }

    static int countPathsToSumOptimized(BinaryTreeNode root, int sum) {
        AtomicInteger count = new AtomicInteger(0);
        countPathsToSumStartingWithNodeOptimized(root, sum, count);
        return count.get();
    }

    private static List<Integer> countPathsToSumStartingWithNodeOptimized(BinaryTreeNode node, int sum, AtomicInteger count) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        List<Integer> leftBranchResult = countPathsToSumStartingWithNodeOptimized(node.leftChild, sum, count);
        List<Integer> rightBranchResult = countPathsToSumStartingWithNodeOptimized(node.rightChild, sum, count);
        result.add(node.name);
        result.addAll(leftBranchResult.stream().map(integer -> integer + node.name).collect(Collectors.toList()));
        result.addAll(rightBranchResult.stream().map(integer -> integer + node.name).collect(Collectors.toList()));
        int pathCount = (int)result.stream().filter(integer -> integer == sum).count();
        if (pathCount > 0) {
            count.addAndGet(pathCount);
        }
        return result;
    }
}
