package com.stmartin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
Coins: Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
pennies (1 cent), write code to calculate the number of ways of representing n cents.
Hints : #300, #324, #343, #380, #394
 */
class Coins {
    static List<List<Money>> numberOfWaysToCalculateNCents(int n) {
        if (n <= 0) {
            return null;
        }
        List<List<Money>> numberOfWays = new ArrayList<>();
        countNumberOfWays(n, Money.quarter, numberOfWays, new ArrayList<>());
        countNumberOfWays(n, Money.dime, numberOfWays, new ArrayList<>());
        countNumberOfWays(n, Money.nickel, numberOfWays, new ArrayList<>());
        countNumberOfWays(n, Money.penny, numberOfWays, new ArrayList<>());
        return numberOfWays;
    }

    private static void countNumberOfWays(int current, Money biggest, List<List<Money>> numberOfWays, List<Money> previous) {
        if (current == 0) {
            numberOfWays.add(previous);
            return;
        }
        List<Money> currentHistory = new ArrayList<>(previous);
        while (current >= biggest.getSize()) {
            current -= biggest.getSize();
            currentHistory = new ArrayList<>(currentHistory);
            currentHistory.add(biggest);
            if (current == 0) {
                numberOfWays.add(currentHistory);
                return;
            }
            Money nextSize = biggest.getNextSize();
            while (nextSize != null) {
                countNumberOfWays(current, nextSize, numberOfWays, new ArrayList<>(currentHistory));
                nextSize = nextSize.getNextSize();
            }
        }
    }

    public enum Money {
        quarter(25),
        dime(10),
        nickel(5),
        penny(1);

        private int size;
        Money(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }

        Money getNextSize() {
            if (this.size == 25) {
                return Money.dime;
            } else if (this.size == 10) {
                return Money.nickel;
            } else if (this.size == 5) {
                return Money.penny;
            }
            return null;
        }
    }
}
