package com.stmartin;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by martinshen on 2017/10/3.
 * StackMin: design a stack class which support a min operation to return the minimum element in the stack. Push, pop
 * and min operations should all be O(1).
 */
class StackMin<T extends Comparable<? super T>> {
    private Stack<StackNode<T>> normalStack;

    public StackMin() {
        normalStack = new Stack<>();
    }

    public void push(T item) {
        if (!isEmpty()) {
            StackNode<T> current = normalStack.peek();
            normalStack.push(new StackNode<>(item, current.min.compareTo(item) < 0 ? current.min : item));
        } else {
            normalStack.push(new StackNode<>(item, item));
        }
    }

    public T pop() {
        return normalStack.pop().data;
    }

    public T peek() {
        return normalStack.peek().data;
    }

    public boolean isEmpty() {
        return normalStack.isEmpty();
    }

    public T min() {
        try {
            StackNode<T> item = normalStack.peek();
            return item.min;
        } catch (EmptyStackException e) {
            return null;
        }
    }

    private static class StackNode<T> {
        T data;
        T min;

        StackNode(T data, T min) {
            this.data = data;
            this.min = min;
        }
    }
}
