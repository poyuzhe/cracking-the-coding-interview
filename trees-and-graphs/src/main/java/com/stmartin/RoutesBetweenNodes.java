package com.stmartin;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by shentong on 2017/10/17.
 * Routes between Nodes: given a directed graph, design an algorithm to determine if there is a route between two nodes.
 */
class RoutesBetweenNodes {
    static boolean hasRoute(Graph graph, Node node1, Node node2) {
        return hasRouteRecursive(node1, node2, "visit1") || hasRouteRecursive(node2, node1, "visit2");
    }

    static private boolean hasRouteRecursive(Node node1, Node node2, String visitKey) {
        // recursively check if every child of node1 has a route to node 2.
        if ("true".equals(node1.getProperty(visitKey))) {
            return false;
        }
        node1.addProperty("visitKey", "true");
        if (node1 == node2) {
            return true;
        }
        for (Node child : node1.children) {
            if (hasRouteRecursive(child, node2, visitKey)) {
                return true;
            }
        }
        // if a node has already been checked, return false.
        // if a child returns true, then return true.
        // default to return false.
        return false;
    }

    static boolean hasRouteBreadthFirst(Graph graph, Node node1, Node node2) {
        if (node1 == node2) {
            return true;
        }
        Queue<Node> visitQueue = new LinkedBlockingQueue<>();
        node1.addProperty("visit1", "true");
        visitQueue.addAll(node1.children);
        while(!visitQueue.isEmpty()) {
            Node currentNode = visitQueue.remove();
            if ("true".equals(currentNode.getProperty("visit\1"))) {
                continue;
            }
            if (currentNode == node2) {
                return true;
            }
            currentNode.addProperty("visit1", "true");
            visitQueue.addAll(currentNode.children);
        }
        node2.addProperty("visit2", "true");
        visitQueue.addAll(node2.children);
        while(!visitQueue.isEmpty()) {
            Node currentNode = visitQueue.remove();
            if ("true".equals(currentNode.getProperty("visit2"))) {
                continue;
            }
            if (currentNode == node1) {
                return true;
            }
            currentNode.addProperty("visit2", "true");
            visitQueue.addAll(currentNode.children);
        }
        return false;
    }
}
