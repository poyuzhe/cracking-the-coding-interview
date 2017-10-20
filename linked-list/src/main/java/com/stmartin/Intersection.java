package com.stmartin;

import com.stmartin.utility.LinkedListNode;

/**
 * Created by martinshen on 2017/10/2.
 * Intersection: given 2 singly linked list, determine if the two lists intersect. Return the intersecting node.
 * The intersection is based on reference, not value.
 */
class Intersection {
    //time complexity: O(max(A,B)), space complexity: O(1)
    static LinkedListNode intersection(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode node1 = head1;
        LinkedListNode node2 = head2;
        LinkedListNode shorter = null;
        int lengthDiff = 0;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                shorter = head1;
                lengthDiff++;
            } else if (node2 == null) {
                shorter = head2;
                lengthDiff++;
            }
            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }
        if (shorter == head1) {
            while (lengthDiff > 0) {
                head2 = head2.next;
                lengthDiff--;
            }
        } else if (shorter == head2) {
            while (lengthDiff > 0) {
                head1 = head1.next;
                lengthDiff--;
            }
        }
        while (head1 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }
}
