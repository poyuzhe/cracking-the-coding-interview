package com.stmartin;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.stmartin.BuildOrder.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shentong on 2017/10/23.
 * Spec:
 * 1. input is a list of projects, and a list of pair of dependencies, where the second project depends on the first project.
 * 2. output is a list of projects detailing the build order.
 */
public class BuildOrderSpec {
    private List<String> projects;
    private List<String[]> dependencies;

    @Before
    public void setUp() {
        projects = new ArrayList<>();
        dependencies = new ArrayList<>();

        projects.add("a");
        projects.add("b");
        projects.add("c");
        projects.add("d");
        projects.add("e");
        projects.add("f");

        dependencies.add(new String[]{"a","d"});
        dependencies.add(new String[]{"f","b"});
        dependencies.add(new String[]{"b","d"});
        dependencies.add(new String[]{"f","a"});
        dependencies.add(new String[]{"d","c"});
    }

    @Test
    public void testBuildOrder() {
        List<String> buildOrder = getBuildOrder(projects, dependencies);
        assertEquals(buildOrder.get(0), "e");
        assertEquals(buildOrder.get(1), "f");
        assertEquals(buildOrder.get(2), "a");
        assertEquals(buildOrder.get(3), "b");
        assertEquals(buildOrder.get(4), "d");
        assertEquals(buildOrder.get(5), "c");
    }
}
