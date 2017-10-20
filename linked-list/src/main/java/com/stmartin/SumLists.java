package com.stmartin;

import com.stmartin.utility.LinkedListNode;

/**
 * Created by martinshen on 2017/9/30.
 * Sum Lists: given two linked lists of numbers. each node represent a digits in reverse order. return the sum
 * represented by a linked list. Then do the same with digits in forward order.
 */
class SumLists {
    //time complexity: O(n), space complexity: O(n)
    static LinkedListNode sumLists(LinkedListNode number1, LinkedListNode number2) {
        LinkedListNode result = null;
        LinkedListNode tail = null;
        boolean addOne = false;
        while (number1 != null || number2 != null) {
            int digit = (number1 != null ? number1.data : 0) + (number2 != null ? number2.data : 0) + (addOne ? 1 : 0);
            addOne = digit >= 10;
            digit = digit % 10;
            LinkedListNode digitNode = new LinkedListNode(digit);
            if (result == null) {
                result = digitNode;
                tail = digitNode;
            } else {
                tail.next = digitNode;
                tail = tail.next;
            }
            number1 = number1 != null ? number1.next : null;
            number2 = number2 != null ? number2.next : null;
        }
        if (addOne) {
            tail.next = new LinkedListNode(1);
        }
        return result;
    }

    //time complexity: O(n), space complexity: O(n)
    static LinkedListNode sumListsRecursive(LinkedListNode number1, LinkedListNode number2) {
        if (number1 == null && number2 == null) {
            return null;
        }
        LinkedListNode previousResult = sumListsRecursive(number1 != null ? number1.next : null,
                number2 != null ? number2.next : null);
        int digit = (number1 != null ? number1.data : 0) + (number2 != null ? number2.data : 0);
        if (digit >= 10) {
            if (previousResult != null) {
                previousResult.data = previousResult.data + 1;
                LinkedListNode result = new LinkedListNode(digit % 10);
                result.next = previousResult;
                return result;
            } else {
                LinkedListNode firstNode = new LinkedListNode(digit % 10);
                firstNode.next = new LinkedListNode(1);
                return firstNode;
            }
        } else {
            LinkedListNode result = new LinkedListNode(digit);
            if (previousResult != null) {
                result.next = previousResult;
            }
            return result;
        }
    }

    //time complexity: O(n), space complexity: O(n)
    static LinkedListNode sumListsForward(LinkedListNode number1, LinkedListNode number2) {
        LinkedListNode head1 = number1;
        LinkedListNode head2 = number2;
        while (number1 != null || number2 != null) {
            if (number1 == null) {
                LinkedListNode newHead1 = new LinkedListNode(0);
                newHead1.next = head1;
                head1 = newHead1;
            }
            if (number2 == null) {
                LinkedListNode newHead2 = new LinkedListNode(0);
                newHead2.next = head2;
                head2 = newHead2;
            }
            number1 = number1 != null ? number1.next : null;
            number2 = number2 != null ? number2.next : null;
        }
        LinkedListNode resultHead = null;
        LinkedListNode resultTail = null;
        int digit = head1.data + head2.data;
        if (digit >= 10) {
            resultHead = new LinkedListNode(1);
            resultHead.next = new LinkedListNode(digit % 10);
            resultTail = resultHead.next;
        } else {
            resultHead = new LinkedListNode(digit);
            resultTail = resultHead;
        }

        head1 = head1.next;
        head2 = head2.next;
        while (head1 != null && head2 != null) {
            digit = head1.data + head2.data;
            if (digit >= 10) {
                resultTail.data = resultTail.data + 1;
                resultTail.next = new LinkedListNode(digit % 10);
            } else {
                resultTail.next = new LinkedListNode(digit);
            }
            resultTail = resultTail.next;
            head1 = head1.next;
            head2 = head2.next;
        }

        return resultHead;
    }
}
