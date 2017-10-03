package com.stmartin;

import com.stmartin.utility.LinkedListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.stmartin.Intersection.*;

/**
 * Created by martinshen on 2017/10/2.
 * Spec:
 * 1. input is 2 singly linked list, with length that may or may not be the same.
 * 2. determine if the 2 list intersect, which means there exist a node that belongs to both list.
 * 3. return that intersecting node, or null if the 2 list do not intersect.
 */
public class IntersectionSpec {
    LinkedListNode head1, head2, head3;
    LinkedListNode intersectingNode;

    @Before
    public void setUp() {
        head1 = new LinkedListNode(3);
        head2 = new LinkedListNode(4);
        head3 = new LinkedListNode(9);
        intersectingNode = new LinkedListNode(1);
        LinkedListNode second1 = new LinkedListNode(2);
        head1.next = second1;
        second1.next = intersectingNode;
        intersectingNode.next = new LinkedListNode(5);
        head2.next = intersectingNode;
        LinkedListNode second3 = new LinkedListNode(1);
        head3.next = second3;
        second3.next = new LinkedListNode(5);
    }

    @Test
    public void whenIntersectingThenReturnIntersectingNode() {
        assertEquals(intersectingNode, intersection(head1, head2));
    }

    @Test
    public void whenNotIntersectingThenReturnNull() {
        assertEquals(null, intersection(head1, head3));
    }
}
