package com.stmartin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shentong on 2017/10/17.
 */
public class Node {
    public String name;
    public List<Node> children;
    public Map<String, String> properties;

    public Node() {
        this("");
    }

    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.properties = new HashMap<>();
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public void removeChild(Node child) {
        this.children.remove(child);
    }

    public void addProperty(String key, String name) {
        properties.put(key, name);
    }

    public String getProperty(String key) {
        return properties.get(key);
    }
}
