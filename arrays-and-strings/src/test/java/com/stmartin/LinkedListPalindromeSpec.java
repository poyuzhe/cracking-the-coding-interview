package com.stmartin;

import com.stmartin.utility.LinkedListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.stmartin.LinkedListPalindrome.*;

/**
 * Created by martinshen on 2017/9/30.
 * spec:
 * 1. input is a linked list.
 * 2. check to see if the linked list is a palindrome, which is the same forward and backward
 * 3. output a boolean of palindrome check.
 */
public class LinkedListPalindromeSpec {
    LinkedListNode palindromeHead;
    LinkedListNode nonPalindromeHead;
    LinkedListNode palindromeHeadEven;
    LinkedListNode nonPalindromeHeadEven;

    @Before
    public void setUp() {
        palindromeHead = new LinkedListNode(1);
        palindromeHead.next = new LinkedListNode(2);
        palindromeHead.next.next = new LinkedListNode(3);
        palindromeHead.next.next.next = new LinkedListNode(2);
        palindromeHead.next.next.next.next = new LinkedListNode(1);

        nonPalindromeHead = new LinkedListNode(1);
        nonPalindromeHead.next = new LinkedListNode(2);
        nonPalindromeHead.next.next = new LinkedListNode(3);
        nonPalindromeHead.next.next.next = new LinkedListNode(2);
        nonPalindromeHead.next.next.next.next = new LinkedListNode(0);

        palindromeHeadEven = new LinkedListNode(1);
        palindromeHeadEven.next = new LinkedListNode(2);
        palindromeHeadEven.next.next = new LinkedListNode(3);
        palindromeHeadEven.next.next.next = new LinkedListNode(3);
        palindromeHeadEven.next.next.next.next = new LinkedListNode(2);
        palindromeHeadEven.next.next.next.next.next = new LinkedListNode(1);

        nonPalindromeHeadEven = new LinkedListNode(1);
        nonPalindromeHeadEven.next = new LinkedListNode(2);
        nonPalindromeHeadEven.next.next = new LinkedListNode(3);
        nonPalindromeHeadEven.next.next.next = new LinkedListNode(3);
        nonPalindromeHeadEven.next.next.next.next = new LinkedListNode(2);
        nonPalindromeHeadEven.next.next.next.next.next = new LinkedListNode(0);
    }

    @Test
    public void whenPalindromeThenTrue() {
        assertTrue(checkPalindrome(palindromeHead));
        assertTrue(checkPalindrome(palindromeHeadEven));
    }

    @Test
    public void whenNotPalindromeThenFalse() {
        assertFalse(checkPalindrome(nonPalindromeHead));
        assertFalse(checkPalindrome(nonPalindromeHeadEven));
    }

    @Test
    public void whenPalindromeThenTrueRecursive() {
        assertTrue(checkPalindromeRecursive(palindromeHead));
        assertTrue(checkPalindromeRecursive(palindromeHeadEven));
    }

    @Test
    public void whenNotPalindromeThenFalseRecursive() {
        assertFalse(checkPalindromeRecursive(nonPalindromeHead));
        assertFalse(checkPalindromeRecursive(nonPalindromeHeadEven));
    }

    @Test
    public void whenPalindromeThenTrueReverse() {
        assertTrue(checkPalindromeReverse(palindromeHead));
        assertTrue(checkPalindromeReverse(palindromeHeadEven));
    }

    @Test
    public void whenNotPalindromeThenFalseReverse() {
        assertFalse(checkPalindromeReverse(nonPalindromeHead));
        assertFalse(checkPalindromeReverse(nonPalindromeHeadEven));
    }

}
