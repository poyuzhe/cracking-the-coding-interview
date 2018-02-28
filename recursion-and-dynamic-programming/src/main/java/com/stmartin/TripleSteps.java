package com.stmartin;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/*
Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.
Hints: # 152, # 178, # 217 , #237 , #262, #359
 */
class TripleSteps {
    static int countSteps(int totalSteps) {
        AtomicInteger count = new AtomicInteger(0);
        AtomicInteger totalPass = new AtomicInteger(0);
        incrementStep(totalSteps, 0, count, totalPass);
        System.out.println("totalStep: " + totalSteps + ", totalPass: " + totalPass.get());
        return count.get();
    }

    private static void incrementStep(int totalSteps, int currentSteps, AtomicInteger count, AtomicInteger totalPass) {
        totalPass.incrementAndGet();
        if (currentSteps >= totalSteps) {
            count.incrementAndGet();
            return;
        }
        if (currentSteps + 1 <= totalSteps) {
            incrementStep(totalSteps, currentSteps + 1, count, totalPass);
        }
        if (currentSteps + 2 <= totalSteps) {
            incrementStep(totalSteps, currentSteps + 2, count, totalPass);
        }
        if (currentSteps + 3 <= totalSteps) {
            incrementStep(totalSteps, currentSteps + 3, count, totalPass);
        }
    }

    static int countStepsTopDown(int totalSteps) {
        AtomicInteger pass = new AtomicInteger(0);
        int[] waysToStep = new int[totalSteps];
        Arrays.fill(waysToStep, 0);
        int count = countTotalWayToStep(totalSteps, pass, waysToStep);
        System.out.println("topDown totalSteps: " + totalSteps + ", totalPass: " + pass.get());
        return count;
    }

    private static int countTotalWayToStep(int currentSteps, AtomicInteger pass, int[] waysToStep) {
        pass.incrementAndGet();
        if (currentSteps == 1 || currentSteps == 0) {
            return 1;
        }
        if (currentSteps < 0) {
            return 0;
        }
        if (waysToStep[currentSteps - 1] != 0) {
            return waysToStep[currentSteps - 1];
        }
        int result = countTotalWayToStep(currentSteps - 1, pass, waysToStep)
                    + countTotalWayToStep(currentSteps - 2, pass, waysToStep)
                    + countTotalWayToStep(currentSteps - 3, pass, waysToStep);
        waysToStep[currentSteps - 1] = result;
        return result;
    }
}
