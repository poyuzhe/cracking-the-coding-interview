package com.stmartin;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.stmartin.RemoveDups.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.LinkedList;

/**
 * Created by shentong on 2017/9/27.
 * spec:
 * 1. input is a LinkedList with arbitrary object type.
 * 2. output is a LinkedList containing all distinct element from the original
 * 3. implement with both a buffer and without any buffers.
 */
public class RemoveDupsSpec {
    private LinkedList<String> original = new LinkedList<>();

    @Before
    public void setUp() {
        original.add("hello");
        original.add("world");
        original.add("hello");
        original.add("me");
    }

    @Test
    public void whenNullInputThenReturnNull() {
        assertEquals(null, removeDups(null));
    }

    @Test
    public void whenInputThenRemoveDuplicate() {
        LinkedList<String> result = removeDups(original);
        assertEquals(3, result.size());
        assertThat(result, hasItem("hello"));
        assertThat(result, hasItem("world"));
        assertThat(result, hasItem("me"));
    }

    @Test
    public void whenNullInputThenReturnNullAdHoc() {
        assertEquals(null, removeDupsAdHoc(null));
    }

    @Test
    public void whenInputThenRemoveDuplicateAdHoc() {
        LinkedList<String> result = removeDupsAdHoc(original);
        assertEquals(3, result.size());
        assertThat(result, hasItem("hello"));
        assertThat(result, hasItem("world"));
        assertThat(result, hasItem("me"));
    }
}
