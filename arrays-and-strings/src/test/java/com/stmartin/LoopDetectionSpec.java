package com.stmartin;

import com.stmartin.utility.LinkedListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.stmartin.LoopDetection.*;

/**
 * Created by martinshen on 2017/10/2.
 * spec:
 * 1. input is a circular linked list
 * 2. output is the beginning node of the loop.
 */
public class LoopDetectionSpec {
    LinkedListNode head1;
    LinkedListNode loopBegin;

    @Before
    public void setUp() {
        head1 = new LinkedListNode(1);
        LinkedListNode second = new LinkedListNode(2);
        head1.next = second;
        loopBegin = new LinkedListNode(3);
        second.next = loopBegin;
        LinkedListNode fourth = new LinkedListNode(4);
        loopBegin.next = fourth;
        LinkedListNode fifth = new LinkedListNode(5);
        fourth.next = fifth;
        fifth.next = loopBegin;
    }

    @Test
    public void whenLoopReturnBeginOfLoop() {
        assertEquals(loopBegin, detectLoop(head1));
    }

    @Test
    public void whenLoopReturnBeginOfLoopAdHoc() {
        assertEquals(loopBegin, detectLoopAdHoc(head1));
    }
}
