package com.stmartin;

import com.stmartin.utility.LinkedListNode;
import org.junit.Before;
import org.junit.Test;

import static com.stmartin.Partition.*;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by martinshen on 2017/9/30.
 * spec:
 * 1. input is a linked list of type T which is comparable, and a value x of type T that may or may not in the linked list
 * 2. output is a rearranged linked list in which all values less than x are before all values equal or larger than x
 */
public class PartitionSpec {
    LinkedList<Integer> input = new LinkedList<>();
    LinkedListNode head, second, third, fourth, fifth, sixth, tail;

    @Before
    public void setUp() {
        input.add(3);
        input.add(5);
        input.add(9);
        input.add(4);
        input.add(7);
        input.add(1);
        input.add(10);
        tail = new LinkedListNode(10);
        sixth = new LinkedListNode(1, tail, null);
        fifth = new LinkedListNode(7, sixth, null);
        fourth = new LinkedListNode(4, fifth, null);
        third = new LinkedListNode(9, fourth, null);
        second = new LinkedListNode(5, third, null);
        head = new LinkedListNode(3, second, null);
    }

    @Test
    public void whenXInListThenPartition() {
        LinkedList<Integer> result = partition(input, 7);
        ListIterator<Integer> iterator = result.listIterator();
        assertTrue(iterator.next() == 3);
        assertTrue(iterator.next() == 5);
        assertTrue(iterator.next() == 4);
        assertTrue(iterator.next() == 1);
        assertTrue(iterator.next() == 9);
        assertTrue(iterator.next() == 7);
        assertTrue(iterator.next() == 10);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void whenXNotInListThenPartition() {
        LinkedList<Integer> result = partition(input, 8);
        ListIterator<Integer> iterator = result.listIterator();
        assertTrue(iterator.next() == 3);
        assertTrue(iterator.next() == 5);
        assertTrue(iterator.next() == 4);
        assertTrue(iterator.next() == 7);
        assertTrue(iterator.next() == 1);
        assertTrue(iterator.next() == 9);
        assertTrue(iterator.next() == 10);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void whenXInListThenPartitionAdHoc() {
        LinkedListNode result = partitionAdHoc(head, 7);
        assertEquals(result.data, 3);
        assertEquals(result.next.data, 5);
        assertEquals(result.next.next.data, 4);
        assertEquals(result.next.next.next.data, 1);
        assertEquals(result.next.next.next.next.data, 9);
        assertEquals(result.next.next.next.next.next.data, 7);
        assertEquals(result.next.next.next.next.next.next.data, 10);
        assertEquals(result.next.next.next.next.next.next.next, null);
    }

    @Test
    public void whenXNotInListThenPartitionAdHoc() {
        LinkedListNode result = partitionAdHoc(head, 8);
        assertEquals(result.data, 3);
        assertEquals(result.next.data, 5);
        assertEquals(result.next.next.data, 4);
        assertEquals(result.next.next.next.data, 7);
        assertEquals(result.next.next.next.next.data, 1);
        assertEquals(result.next.next.next.next.next.data, 9);
        assertEquals(result.next.next.next.next.next.next.data, 10);
        assertEquals(result.next.next.next.next.next.next.next, null);
    }

    @Test
    public void whenXSmallestThenPartitionAdHoc() {
        LinkedListNode result = partitionAdHoc(head, 0);
        assertEquals(result.data, 3);
        assertEquals(result.next.data, 5);
        assertEquals(result.next.next.data, 9);
        assertEquals(result.next.next.next.data, 4);
        assertEquals(result.next.next.next.next.data, 7);
        assertEquals(result.next.next.next.next.next.data, 1);
        assertEquals(result.next.next.next.next.next.next.data, 10);
        assertEquals(result.next.next.next.next.next.next.next, null);
    }

    @Test
    public void whenXLargestThenPartitionAdHoc() {
        LinkedListNode result = partitionAdHoc(head, 11);
        assertEquals(result.data, 3);
        assertEquals(result.next.data, 5);
        assertEquals(result.next.next.data, 9);
        assertEquals(result.next.next.next.data, 4);
        assertEquals(result.next.next.next.next.data, 7);
        assertEquals(result.next.next.next.next.next.data, 1);
        assertEquals(result.next.next.next.next.next.next.data, 10);
        assertEquals(result.next.next.next.next.next.next.next, null);
    }
}
