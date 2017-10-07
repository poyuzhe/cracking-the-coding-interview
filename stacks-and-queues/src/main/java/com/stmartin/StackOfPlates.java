package com.stmartin;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * Created by martinshen on 2017/10/3.
 * Stack of Plates: multiple stack, when the last stack is full, create a new stack and push into the new one.
 */
class StackOfPlates<T> {
    List<Stack<T>> stacks;
    int size;

    public StackOfPlates(int size) {
        this.size = size;
        stacks = new ArrayList<>();
        stacks.add(new Stack<>());
    }

    public void push(T item) {
        if (stacks.size() == 0) {
            stacks.add(new Stack<>());
        }
        Stack<T> lastStack = stacks.get(stacks.size() - 1);
        if (lastStack.size() == size) {
            Stack<T> newStack = new Stack<>();
            stacks.add(newStack);
            newStack.push(item);
        } else {
            lastStack.push(item);
        }
    }

    public T pop() {
        Stack<T> lastStack = stacks.get(stacks.size() - 1);
        if (lastStack.size() == 0) {
            stacks.remove(stacks.size() - 1);
            if (stacks.size() == 0) {
                throw new EmptyStackException();
            } else {
                return stacks.get(stacks.size() - 1).pop();
            }
        } else {
            return lastStack.pop();
        }
    }

    public T peek() {
        Stack<T> lastStack = stacks.get(stacks.size() - 1);
        if (lastStack.size() == 0) {
            stacks.remove(stacks.size() - 1);
            if (stacks.size() == 0) {
                throw new EmptyStackException();
            } else {
                return stacks.get(stacks.size() - 1).peek();
            }
        } else {
            return lastStack.peek();
        }
    }

    public boolean isEmpty() {
        return stacks.size() == 0 || stacks.get(0).isEmpty();
    }

    public T popAt(int stackNum) {
        if (stackNum >= stacks.size()) {
            throw new RuntimeException();
        }
        Stack<T> stackAt = stacks.get(stackNum);
        return stackAt.pop();
    }
}
