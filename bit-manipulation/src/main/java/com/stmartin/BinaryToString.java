package com.stmartin;

/**
 * Created by shentong on 2017/11/17.
 * Binary to String: Given a real number between 0 and 1 (e .g., 0. 72) that is passed in as a double, print
 the binary representation. If the number cannot be represented accurately in binary with at most 32
 characters, print "ERROR:'
 Hints: #143, #167, #173, #269, #297
 */
class BinaryToString {
    static String binaryToString(double n) {
        StringBuilder s = new StringBuilder("0.");
        int count = 0;
        double remain = n;
        do {
            remain = remain * 2;
            count++;
            if (remain < 1) {
                s.append(0);
            } else {
                s.append(1);
                remain = remain - 1;
                if (remain == 0) {
                    break;
                }
            }
        } while(remain != 0 && count < 32);
        if (count == 32) {
            return "ERROR:";
        }
        return s.toString();
    }
}
