package com.stmartin;

import java.util.Stack;

/**
 * Created by martinshen on 2017/10/3.
 * Sort Stack: sort a stack so that the smaller item is on top. Can use another stack as temporary storage but no
 * other data structure.
 */
class SortStack {
    static <T extends Comparable<? super T>> Stack<T> sortStack(Stack<T> stack) {
        if (stack == null || stack.size() == 0) {
            return stack;
        }
        Stack<T> cache = new Stack<>();
        while (!stack.isEmpty()) {
            T item = stack.pop();
            while (!cache.isEmpty() && cache.peek().compareTo(item) > 0) {
                stack.push(cache.pop());
            }
            cache.push(item);
        }
        while (!cache.isEmpty()) {
            stack.push(cache.pop());
        }
        return stack;
    }
}
