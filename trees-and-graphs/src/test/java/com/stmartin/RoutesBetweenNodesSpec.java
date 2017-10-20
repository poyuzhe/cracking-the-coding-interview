package com.stmartin;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.stmartin.RoutesBetweenNodes.*;

/**
 * Created by shentong on 2017/10/17.
 * Spec:
 * 1. input is a directed graph and two nodes in this graph.
 * 2. output is a boolean value depending on whether the two nodes is connected in this graph.
 */
public class RoutesBetweenNodesSpec {
    private Graph graph;
    private Node connectedNode1;
    private Node connectedNode2;
    private Node disconnectedNode1;

    @Before
    public void setUp() {
        connectedNode1 = new Node("");
        Node child1 = new Node();
        Node child2 = new Node();
        connectedNode1.addChild(child1);
        connectedNode1.addChild(child2);
        Node child3 = new Node();
        Node child4 = new Node();
        child1.addChild(child3);
        child1.addChild(child4);
        Node child5 = new Node();
        connectedNode2 = new Node();
        child2.addChild(child5);
        child2.addChild(connectedNode2);

        disconnectedNode1 = new Node();
        disconnectedNode1.addChild(child5);

        graph = new Graph();
        graph.addNode(connectedNode1);
        graph.addNode(child1);
        graph.addNode(child2);
        graph.addNode(child3);
        graph.addNode(child4);
        graph.addNode(child5);
        graph.addNode(connectedNode2);
        graph.addNode(disconnectedNode1);
    }

    @Test
    public void whenConnectedThenTrue() {
        assertTrue(hasRoute(graph, connectedNode1, connectedNode2));
        assertTrue(hasRoute(graph, connectedNode2, connectedNode1));
    }

    @Test
    public void whenDisconnectedThenFalse() {
        assertFalse(hasRoute(graph, connectedNode1, disconnectedNode1));
    }

    @Test
    public void whenConnectedThenTrueBreadthFirst() {
        assertTrue(hasRouteBreadthFirst(graph, connectedNode1, connectedNode2));
        assertTrue(hasRouteBreadthFirst(graph, connectedNode2, connectedNode1));
    }

    @Test
    public void whenDisconnectedThenFalseBreadthFirst() {
        assertFalse(hasRouteBreadthFirst(graph, connectedNode1, disconnectedNode1));
    }
}
