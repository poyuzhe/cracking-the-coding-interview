package com.stmartin;

import com.stmartin.utility.LinkedListNode;

import java.util.Stack;

/**
 * Created by martinshen on 2017/9/30.
 * check to see if a linked list is a palindrome
 */
class LinkedListPalindrome {
    //time complexity: O(n), space complexity: O(n)
    static boolean checkPalindrome(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        Stack<LinkedListNode> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (slow.data != stack.pop().data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    //time complexity: O(n), space complexity: O(n)
    static boolean checkPalindromeReverse(LinkedListNode head) {
        LinkedListNode reverse = new LinkedListNode(head.data);
        LinkedListNode node = head.next;
        while (node != null) {
            LinkedListNode previous = new LinkedListNode(node.data);
            previous.next = reverse;
            reverse = previous;
            node = node.next;
        }
        while (reverse != null) {
            if (head.data != reverse.data) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }

    //time complexity: O(n), space complexity: O(n)
    static boolean checkPalindromeRecursive(LinkedListNode head) {
        int length = 0;
        LinkedListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        PalindromeResult result = checkPalindromeRecursiveWithLength(head, 0, length);
        return result.isPalindrome;
    }

    private static PalindromeResult checkPalindromeRecursiveWithLength(LinkedListNode head, int currentIndex, int length) {
        if (length % 2 == 1 && currentIndex == (length - 1) / 2) {
            return new PalindromeResult(true, head.next);
        }
        if (length % 2 == 0 && currentIndex == length / 2 - 1) {
            return new PalindromeResult(head.data == head.next.data, head.next.next);
        }
        PalindromeResult result = checkPalindromeRecursiveWithLength(head.next, ++currentIndex, length);
        if (!result.isPalindrome) {
            return result;
        }
        if (head.data != result.nextNode.data) {
            result.isPalindrome = false;
            return result;
        }
        result.nextNode = result.nextNode.next;
        return result;
    }

    public static class PalindromeResult {
        boolean isPalindrome;
        LinkedListNode nextNode;

        public PalindromeResult(boolean isPalindrome, LinkedListNode nextNode) {
            this.isPalindrome = isPalindrome;
            this.nextNode = nextNode;
        }
    }
}
