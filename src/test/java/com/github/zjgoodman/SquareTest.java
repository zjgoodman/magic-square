package com.github.zjgoodman;

import org.junit.Assert;
import org.junit.Test;

import static com.github.zjgoodman.Sample3x3Square.SAMPLE_DATA;

import java.util.Arrays;
import java.util.List;

public class SquareTest {
    private final Square square = new Sample3x3Square();
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

    @Test
    public void testIsMagicSquare3x3() throws Exception {
        Square notMagicSquare = new Sample3x3Square();
        Assert.assertFalse(notMagicSquare.isMagicSquare());

        Square magicSquare = new Sample3x3MagicSquare();
        Assert.assertTrue(magicSquare.isMagicSquare());
    }

    @Test
    public void testIsMagicSquare5x5() throws Exception {
        Square magicSquare = new Sample5x5MagicSquare();
        Assert.assertTrue(magicSquare.isMagicSquare());
    }

    @Test
    public void testGetColumnsIndividually() throws Exception {
        Square square = new Sample3x3Square();
        List<List<Integer>> expectedColumns = Arrays.asList(Arrays.asList(1, 4, 7), Arrays.asList(2, 5, 8),
                Arrays.asList(3, 6, 9));

        for (int i = 0; i < expectedColumns.size(); ++i) {
            List<Integer> expectedColumn = expectedColumns.get(i);
            List<Integer> actualColumn = square.getColumn(i);

            Assert.assertEquals(expectedColumn, actualColumn);
        }
    }

    @Test
    public void testGetColumns() throws Exception {
        Square square = new Sample3x3Square();
        List<List<Integer>> expectedColumns = Arrays.asList(Arrays.asList(1, 4, 7), Arrays.asList(2, 5, 8),
                Arrays.asList(3, 6, 9));
        List<List<Integer>> actualColumns = square.getColumns();
        Assert.assertEquals(expectedColumns, actualColumns);
    }

    @Test
    public void testGetTopLeftBottomRightDiagonal() throws Exception {
        Square square = new Sample3x3Square();
        List<Integer> expectedDiagonal = Arrays.asList(1, 5, 9);
        List<Integer> actualDiagonal = square.getTopLeftBottomRightDiagonal();
        Assert.assertEquals(expectedDiagonal, actualDiagonal);
    }

    @Test
    public void testGetBottomLeftTopRightDiagonal() throws Exception {
        Square square = new Sample3x3Square();
        List<Integer> expectedDiagonal = Arrays.asList(7, 5, 3);
        List<Integer> actualDiagonal = square.getBottomLeftTopRightDiagonal();
        Assert.assertEquals(expectedDiagonal, actualDiagonal);
    }
}
