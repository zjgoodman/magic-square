package com.github.zjgoodman;

import org.junit.Assert;
import org.junit.Test;

public class SquareTest {
    private final int[][] data = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    private final Square square = new Square(data);

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
