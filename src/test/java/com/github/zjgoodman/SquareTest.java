package com.github.zjgoodman;

import org.junit.Assert;
import org.junit.Test;

import static com.github.zjgoodman.SampleSquare.SAMPLE_DATA;

public class SquareTest {
    private final Square square = new SampleSquare();
    private final int[][] data = SAMPLE_DATA;

    @Test
    public void testGetValue() throws Exception {
        Assert.assertTrue(square.size() > 0);
        for (int row = 0; row < data.length; ++row) {
            for (int column = 0; column < data.length; ++column) {
                int expectedValue = data[row][column];
                int actualValue = square.getValue(row, column);
                Assert.assertEquals(expectedValue, actualValue);
            }
        }
    }

    @Test
    public void testToString() throws Exception {
        String expectedString = "[1, 2, 3]\n[4, 5, 6]\n[7, 8, 9]";
        String actualString = square.toString();
        Assert.assertEquals(expectedString, actualString);
    }
}
