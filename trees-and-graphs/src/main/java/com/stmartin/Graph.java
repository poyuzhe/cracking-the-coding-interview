package com.stmartin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shentong on 2017/10/17.
 */
public class Graph {
    public List<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }
}
