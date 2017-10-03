package com.stmartin;

import com.stmartin.utility.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by martinshen on 2017/10/2.
 * loop detection: given a circular linked list, return the node at the beginning of the loop.
 */
class LoopDetection {
    //time complexity: O(n), space complexity: O(n)
    static LinkedListNode detectLoop(LinkedListNode head) {
        Set<LinkedListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    //time complexity: O(n), space complexity: O(1)
    static LinkedListNode detectLoopAdHoc(LinkedListNode head) {
        LinkedListNode fastRunner = head;
        LinkedListNode slowRunner = head;
        while (fastRunner.next.next != slowRunner.next) {
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
        }

        LinkedListNode collisionPoint = slowRunner.next;
        while (head != collisionPoint) {
            head = head.next;
            collisionPoint = collisionPoint.next;
        }

        return head;
    }
}
