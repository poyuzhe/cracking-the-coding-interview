package com.stmartin;

/*
Poison: you have 1000 bottles of soda, and exactly one bottle is poisonous. You have 10 test strips to test for which
one is poisonous. Each test strips can be reused for unlimited time until one test turned positive which will be permanent.
You can conduct multiple tests at once but to return test results you have to wait for a week. Devise a test plan that
utilizes the shortest time.
 */
class Poison {
    static boolean[] returnTestResultForPoisonedBottle(int index) {
        boolean[] result = new boolean[10];
        for (int i = 0; i < 10; i++) {
            result[i] = (index & (1 << i)) != 0;
        }
        return result;
    }

    static int deducePoisonedBottleIndexByTestResult(boolean[] result) {
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            index += result[i] ? Math.pow(2, i) : 0;
        }
        return index;
    }
}
