package com.stmartin;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by shentong on 2017/9/27.
 * spec:
 * 1. input is a LinkedList with arbitrary element and an index k
 * 2. output is a LinkedList with kth to last element of the input list
 * 3. if k > length of input list, then return null
 */
public class ReturnKthToLastSpec {
    private LinkedList<String> original = new LinkedList<>();

    @Before
    public void setUp() {
        original.add("hello");
        original.add("world");
        original.add("me");
        original.add("too");
    }

    @Test
    public void whenNullListThenReturnNull {

    }
}
