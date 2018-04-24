package com.stmartin;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/*
Stack of Boxes: You have a stack of n boxes, with widths wi, heights hi, and depths di. The boxes
cannot be rotated and can only be stacked on top of one another if each box in the stack is strictly
larger than the box above it in width, height, and depth. Implement a method to compute the
height of the tallest possible stack. The height of a stack is the sum of the heights of each box.
Hints: #155, #194, #214, #260, #322, #368, #378
 */
class StackOfBoxes {
    static int calculateTallestPossibleStack(List<Box> boxes) {
        boxes.sort(Comparator.comparingInt(Box::getWidth).reversed());
        Map<Box, Integer> boxMaxHeight = new HashMap<>();
        AtomicInteger maxHeight = new AtomicInteger(0);
        for (int index = 0; index < boxes.size(); index++) {
            Box box = boxes.get(index);
            if (!boxMaxHeight.containsKey(box)) {
                int height = getBoxMaxHeight(boxes, index, boxMaxHeight);
                if (height > maxHeight.get()) {
                    maxHeight.set(height);
                }
            }
        }
        return maxHeight.get();
    }

    private static int getBoxMaxHeight(List<Box> boxes, int index, Map<Box, Integer> boxMaxHeight) {
        if (index >= boxes.size() || index < 0) {
            return 0;
        }

        Box base = boxes.get(index);
        if (boxMaxHeight.containsKey(base)) {
            return boxMaxHeight.get(base);
        }

        int height = base.getHeight();
        while(index < boxes.size() - 1) {
            index++;
            if (base.isBiggerThan(boxes.get(index))) {
                height += getBoxMaxHeight(boxes, index, boxMaxHeight);
                break;
            }
        }

        boxMaxHeight.put(base, height);
        return height;
    }

    static class Box {
        private int width;
        private int height;
        private int depth;

        Box(int width, int height, int depth) {
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        boolean isBiggerThan(Box another) {
            return this.width > another.getWidth() && this.height > another.getHeight() && this.depth > another.getDepth();
        }

        int getWidth() {
            return width;
        }

        int getHeight() {
            return height;
        }

        int getDepth() {
            return depth;
        }
    }
}
