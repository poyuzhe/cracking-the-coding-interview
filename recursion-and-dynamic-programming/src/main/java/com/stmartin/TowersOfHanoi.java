package com.stmartin;

import java.util.Stack;

/*
Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order
of size from top to bottom (Le., each disk sits on top of an even larger one). You have the following
constraints:
(1) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto another tower.
(3) A disk cannot be placed on top of a smaller disk.
Write a program to move the disks from the first tower to the last using stacks .
Hints: #144, #224, #250, #272, #318
 */
class TowersOfHanoi {
    static void movePlatesTo3rdTower(Stack<Double> tower1, Stack<Double> tower2, Stack<Double> tower3) {
        moveTopNPlates(tower1.size(), tower1, tower2, tower3);
    }

    private static void moveTopNPlates(int n, Stack<Double> source, Stack<Double> buffer, Stack<Double> destination) {
        if (n <= 0) {
            return;
        }
        if (n == 1) {
            destination.push(source.pop());
            return;
        }

        moveTopNPlates(n - 1, source, destination, buffer);
        moveTopNPlates(1, source, buffer, destination);
        moveTopNPlates(n - 1, buffer, source, destination);
    }
}
