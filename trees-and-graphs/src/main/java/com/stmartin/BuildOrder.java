package com.stmartin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shentong on 2017/10/23.
 * Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
 projects, where the second project is dependent on the first project ). All of a project's dependencies
 must be built before the project is . Find a build order that will allow the projects to be built. If there
 is no valid build order, return an error.
 EXAMPLE
 Input:
 projects: a, b, c, d, e, f
 dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 Output: f, e, a, b, d, c
 Hints: #26 , #47, #60 , #85 , #125, #133
 */
class BuildOrder {
    static List<String> getBuildOrder(List<String> projects, List<String[]> dependencies) {
        Map<String, Node> projectNodeMap = createNodeMapFromProjects(projects, dependencies);
        List<String> buildOrder = new ArrayList<>();
        List<Node> projectNodes = new ArrayList<>(projectNodeMap.values());
        boolean builtNode = false;
        while (buildOrder.size() < projectNodes.size()) {
            builtNode = false;
            for (Node project : projectNodes) {
                if (null == project.getProperty("built")) {
                    int nonBuiltChild = project.children.size();
                    for (Node child : project.children) {
                        if (null != child.getProperty("built")) {
                            nonBuiltChild--;
                        }
                    }
                    if (nonBuiltChild == 0) {
                        buildOrder.add(project.name);
                        project.addProperty("built", "true");
                        builtNode = true;
                    }
                }
            }
            if (!builtNode) {
                return null;
            }
        }
        return buildOrder;
    }

    static List<String> getBuildOrderDepthFirst(List<String> projects, List<String[]> dependencies) {
        Map<String, Node> projectNodeMap = createNodeMapFromProjects(projects, dependencies);
        List<String> buildOrder = new ArrayList<>();
        List<Node> projectNodes = new ArrayList<>(projectNodeMap.values());
        for (Node project : projectNodes) {
            if (!depthFirstTraversal(project, buildOrder)) {
                return null;
            }
        }
        return buildOrder;
    }

    private static boolean depthFirstTraversal(Node project, List<String> buildOrder) {
        if ("completed".equals(project.getProperty("status"))) {
            return true;
        }
        if ("partial".equals(project.getProperty("status"))) {
            return false;
        }
        project.addProperty("status", "partial");
        if (project.children == null || project.children.size() == 0) {
            buildOrder.add(project.name);
            project.addProperty("status", "completed");
            return true;
        }
        for (Node child : project.children) {
            if (!depthFirstTraversal(child, buildOrder)) {
                return false;
            }
        }
        buildOrder.add(project.name);
        project.addProperty("status", "completed");
        return true;
    }

    private static Map<String, Node> createNodeMapFromProjects(List<String> projects, List<String[]> dependencies) {
        Map<String, Node> projectNodeMap = new HashMap<>();
        for (String project : projects) {
            projectNodeMap.put(project, new Node(project));
        }
        for (String[] dependency : dependencies) {
            Node dependent = projectNodeMap.get(dependency[1]);
            Node dependentOn = projectNodeMap.get(dependency[0]);
            dependent.addChild(dependentOn);
        }
        return projectNodeMap;
    }
}
