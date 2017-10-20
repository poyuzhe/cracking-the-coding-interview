package com.stmartin;

import com.stmartin.utility.LinkedListNode;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by martinshen on 2017/9/30.
 * Partition: given a linked list and a value x, arrange the value less than x to be before the value larger than x,
 * if value x is in the linked list, then x only need to be after elements less than x.
 */
class Partition {
    //time complexity: O(n), space complexity: O(n)
    static <T extends Comparable<? super T>> LinkedList<T> partition(LinkedList<T> input, T x) {
        ListIterator<T> iterator = input.listIterator();
        LinkedList<T> bigElements = new LinkedList<>();
        while (iterator.hasNext()) {
            T data = iterator.next();
            if (data.compareTo(x) >= 0) {
                bigElements.add(data);
                iterator.remove();
            }
        }
        input.addAll(bigElements);
        return input;
    }

    //time complexity: O(n), space complexity: O(1)
    static LinkedListNode partitionAdHoc(LinkedListNode head, int x) {
        LinkedListNode node = head;
        LinkedListNode largeHead = null;
        LinkedListNode largeTail = null;
        LinkedListNode smallTail = null;
        boolean foundSmall = false;
        //loop through elements, find the first element that is smaller than x, and make it the new head.
        //for other elements that are large or equal to x, remove them from the original link and form a new link
        while (node != null) {
            if (node.data >= x) {
                if (largeHead == null) {
                    largeHead = node;
                    largeTail = node;
                } else {
                    largeTail.next = node;
                    largeTail = largeTail.next;
                }
            } else {
                if (!foundSmall) {
                    foundSmall = true;
                    head = node;
                    smallTail = head;
                } else {
                    smallTail.next = node;
                    smallTail = smallTail.next;
                }
                if (largeTail != null) {
                    largeTail.next = null;
                }
            }
            node = node.next;
        }

        if (smallTail != null && largeHead != null) {
            smallTail.next = largeHead;
        }

        return head;
    }
}
