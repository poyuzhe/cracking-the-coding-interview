package com.stmartin;

import java.util.*;

/**
 * Created by shentong on 2017/9/27.
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 FOLLOW UP
 How would you solve this problem if a temporary buffer is not allowed?
 Hints: #9, #40
 */
class RemoveDups {
    //time complexity: O(n)
    static <T> LinkedList<T> removeDups(LinkedList<T> original) {
        if (original == null) {
            return null;
        }
        Set<T> uniqueItems = new HashSet<>();
        ListIterator<T> iterator = original.listIterator();
        while(iterator.hasNext()) {
            T current = iterator.next();
            if (uniqueItems.contains(current)) {
                iterator.remove();
            } else {
                uniqueItems.add(current);
            }
        }
        return original;
    }

    //time complexity: O(n*n)
    static <T extends Comparable<? super T>> LinkedList<T> removeDupsAdHoc(LinkedList<T> original) {
        if (original == null) {
            return null;
        }

        ListIterator<T> iterator = original.listIterator();
        while(iterator.hasNext()) {
            T current = iterator.next();
            if (current == null) {
                iterator.remove();
                continue;
            }
            ListIterator<T> iterator1 = original.listIterator(iterator.nextIndex());
            while(iterator1.hasNext()) {
                T loopValue = iterator1.next();
                if (loopValue == current) {
                    iterator1.set(null);
                }
            }
        }
        return original;
    }
}
