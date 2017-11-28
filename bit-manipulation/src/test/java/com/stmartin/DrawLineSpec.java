package com.stmartin;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
import static com.stmartin.DrawLine.*;

/**
 * Created by shentong on 2017/11/27.
 * spec:
 * 1. input: a byte array as the screen. the width of the screen which is divisible by 8. the x of the start and the end
 * of the line as x1 and x2. the y of the line.
 * 2. output: draw the line.
 */
public class DrawLineSpec {
    private byte[] screen;
    private int width;
    private int x1;
    private int x2;
    private int y;

    @Before
    public void setUp() {
        width = 16;
        x1 = 3;
        x2 = 12;
        y = 1;
        screen = new byte[]{12, 15, 25, 34,102};
    }

    @Test
    public void drawLineSpec() {
        drawLine(screen, width, x1, x2, y);
    }
}
