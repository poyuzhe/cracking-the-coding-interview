package com.stmartin;

import java.util.LinkedList;

/**
 * Created by shentong on 2017/9/27.
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 Hints: #8, #25, #47, #6 7, # 726
 */
class ReturnKthToLast {
    static <T> LinkedList<T> kthToLast(LinkedList<T> original, int k) {
        if (original == null) {
            return null;
        }
        if (k > original.size()) {
            return null;
        }
        throw new RuntimeException();
    }
}
