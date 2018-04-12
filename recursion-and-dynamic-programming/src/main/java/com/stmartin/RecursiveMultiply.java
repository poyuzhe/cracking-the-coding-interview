package com.stmartin;

/*
Recursive Multiply: Write a recursive function to multiply two positive integers without using the
* operator. You can use addition, subtraction, and bit shifting, but you should minimize the number
of those operations.
Hints: # 166, #203, #227, #234, #246, #280
 */
class RecursiveMultiply {
    static int recursiveMultiply(int number1, int number2) {
        int smallInt = (number1 > number2) ? number2 : number1;
        int bigInt = (number1 > number2) ? number1 : number2;
        int result = 0;
        int currentStep = 0;
        while (smallInt > 0) {
            int lastDigit = smallInt & 1;
            if (currentStep == 0) {
                currentStep = bigInt;
            } else {
                currentStep = currentStep + currentStep;
            }
            if (lastDigit == 1) {
                result += currentStep;
            }
            smallInt = smallInt >> 1;
            if (smallInt == 0) {
                break;
            }
        }
        return result;
    }
}
