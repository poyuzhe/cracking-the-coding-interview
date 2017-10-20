package com.stmartin;

import com.stmartin.utility.LinkedListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.stmartin.DeleteMiddleNode.*;

/**
 * Created by martinshen on 2017/9/30.
 * spec:
 * 1. given a node of a singly linked list, this node is neither the first node nor the last node
 * 2. remove the node from the linked list
 * 3. return nothing
 */
public class DeleteMiddleNodeSpec {
    LinkedListNode head, second, third, last;

    @Before
    public void setUp() {
        last = new LinkedListNode(4);
        third = new LinkedListNode(3, last, null);
        second = new LinkedListNode(2, third, null);
        head = new LinkedListNode(1, second, null);
    }

    @Test
    public void whenGivenSecondThenRemoveSecond() {
        deleteMiddleNode(second);
        assertEquals(head.data, 1);
        assertEquals(head.next.data, 3);
        assertEquals(head.next.next.data, 4);
        assertEquals(head.next.next.next, null);
    }
}
