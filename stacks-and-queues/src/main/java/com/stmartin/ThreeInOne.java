package com.stmartin;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by martinshen on 2017/10/3.
 * Three in One: implement three stacks in one array
 */
class ThreeInOne {
    static <T> StackOnArray<T> threeInOne(T[] baseArray) {
        if (baseArray == null || baseArray.length < 3) {
            return null;
        }
        int length = baseArray.length;
        int startIndex1 = 0;
        int startIndex2 = length / 3;
        int startIndex3 = length * 2 / 3;
        int[] startIndex = new int[]{startIndex1, startIndex2, startIndex3};
        int[] capacities = new int[]{startIndex2 - startIndex1, startIndex3 - startIndex2, length - startIndex3};
        return new StackOnArray<>(baseArray, startIndex, capacities);
    }

    public static class StackOnArray<T> {
        T[] baseArray;
        int[] startIndex;
        int[] capacity;
        int[] endIndex;

        public StackOnArray(T[] baseArray, int[] startIndex, int[] capacity) {
            this.baseArray = baseArray;
            this.startIndex = startIndex;
            this.capacity = capacity;
            this.endIndex = startIndex.clone();
        }

        public void push(int stackNum, T item) {
            if (isFull(stackNum)) {
                increaseCapacity(stackNum);
            }
            baseArray[endIndex[stackNum]] = item;
            endIndex[stackNum] = findNextIndex(endIndex[stackNum]);
        }

        public T pop(int stackNum) {
            if (isEmpty(stackNum)) {
                throw new EmptyStackException();
            }
            T item = baseArray[findPreviousIndex(endIndex[stackNum])];
            baseArray[findPreviousIndex(endIndex[stackNum])] = null;
            endIndex[stackNum] = findPreviousIndex(endIndex[stackNum]);
            return item;
        }

        public T peek(int stackNum) {
            if (isEmpty(stackNum)) {
                throw new EmptyStackException();
            }
            return baseArray[endIndex[stackNum] - 1];
        }

        public boolean isEmpty(int stackNum) {
            return endIndex[stackNum] == startIndex[stackNum];
        }

        private int size(int stackNum) {
            if (endIndex[stackNum] >= startIndex[stackNum]) {
                return endIndex[stackNum] - startIndex[stackNum];
            } else {
                return baseArray.length - startIndex[stackNum] + endIndex[stackNum];
            }
        }

        private boolean isFull(int stackNum) {
            return size(stackNum) == capacity[stackNum];
        }

        private int findNextIndex(int index) {
            if (index == baseArray.length - 1) {
                return 0;
            }
            return index + 1;
        }

        private int findPreviousIndex(int index) {
            if (index == 0) {
                return baseArray.length - 1;
            }
            return index - 1;
        }

        private void rightShift(int stackNum) {
            for (int index = endIndex[stackNum] - 1; index >= startIndex[stackNum]; index--) {
                baseArray[findNextIndex(index)] = baseArray[index];
            }
            endIndex[stackNum] = findNextIndex(endIndex[stackNum]);
            startIndex[stackNum] = findNextIndex(startIndex[stackNum]);
        }

        private void increaseCapacity(int stackNum) {
            //check if next stack is full, if not full, shift next stack
            int nextStack = (stackNum + 1) % 3;
            if (!isFull(nextStack)) {
                rightShift(nextStack);
                capacity[nextStack]--;
                capacity[stackNum]++;
            } else {
                //else, check if next next stack is full, if not full, shift next stack and next next stack
                int nextNextStack = (nextStack + 1) % 3;
                if (!isFull(nextNextStack)) {
                    rightShift(nextNextStack);
                    rightShift(nextNextStack);
                    capacity[nextNextStack]--;
                    capacity[stackNum]++;
                } else {
                    throw new StackFullException();
                }
            }
        }
    }

    public static class StackFullException extends RuntimeException {

    }
}
