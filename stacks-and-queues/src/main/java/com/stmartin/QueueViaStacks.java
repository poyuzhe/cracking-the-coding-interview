package com.stmartin;

import java.util.Stack;

/**
 * Created by martinshen on 2017/10/3.
 * Queue via stacks: implement a queue class using two stacks
 */
class QueueViaStacks<T> {
    private Stack<T> addStack;
    private Stack<T> removeStack;
    boolean isLastRemove;

    public QueueViaStacks() {
        addStack = new Stack<>();
        removeStack = new Stack<>();
        isLastRemove = false;
    }

    public void add(T item) {
        if (isLastRemove) {
            while (!removeStack.isEmpty()) {
                addStack.push(removeStack.pop());
            }
        }
        addStack.add(item);
        isLastRemove = false;
    }

    public T peek() {
        if (!isLastRemove) {
            while (!addStack.isEmpty()) {
                removeStack.push(addStack.pop());
            }
        }
        isLastRemove = true;
        return removeStack.peek();
    }

    public T remove() {
        if (!isLastRemove) {
            while (!addStack.isEmpty()) {
                removeStack.push(addStack.pop());
            }
        }
        isLastRemove = true;
        return removeStack.pop();
    }

    public boolean isEmpty() {
        return isLastRemove ? removeStack.isEmpty() : addStack.isEmpty();
    }
}
