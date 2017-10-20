package com.stmartin;

import com.stmartin.utility.LinkedListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.stmartin.SumLists.*;

/**
 * Created by martinshen on 2017/9/30.
 * spec:
 * 1. input is two linked list of ints.
 * 2. each linked list node is a digit, the whole linked list is a number with digits in reverse order.
 * 3. output is a linked list of ints whose number representation is the sum of the two linked list input.
 * 4. then do it in reverse order.
 */
public class SumListsSpec {
    LinkedListNode head1, head2;

    @Before
    public void setUp() {
        LinkedListNode tail1 = new LinkedListNode(5);
        LinkedListNode middle1 = new LinkedListNode(4, tail1, null);
        head1 = new LinkedListNode(3, middle1, null);

        LinkedListNode tail2 = new LinkedListNode(9);
        LinkedListNode middle2 = new LinkedListNode(1, tail2, null);
        LinkedListNode anotherMiddle2 = new LinkedListNode(8, middle2, null);
        head2 = new LinkedListNode(6, anotherMiddle2, null);
    }

    @Test
    public void whenReverseThenSumList() {
        LinkedListNode result = sumLists(head1, head2);
        assertEquals(result.data, 9);
        assertEquals(result.next.data, 2);
        assertEquals(result.next.next.data, 7);
        assertEquals(result.next.next.next.data, 9);
        assertEquals(result.next.next.next.next, null);
    }

    @Test
    public void whenReverseThenSumListRecursive() {
        LinkedListNode result = sumListsRecursive(head1, head2);
        assertEquals(result.data, 9);
        assertEquals(result.next.data, 2);
        assertEquals(result.next.next.data, 7);
        assertEquals(result.next.next.next.data, 9);
        assertEquals(result.next.next.next.next, null);
    }

    @Test
    public void whenForwardThenSumList() {
        LinkedListNode result = sumListsForward(head1, head2);
        assertEquals(result.data, 7);
        assertEquals(result.next.data, 1);
        assertEquals(result.next.next.data, 6);
        assertEquals(result.next.next.next.data, 4);
        assertEquals(result.next.next.next.next, null);
    }
}
