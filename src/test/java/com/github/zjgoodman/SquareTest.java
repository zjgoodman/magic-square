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

    @Test
    public void testEquals() throws Exception {
        Square sample3x3magic = new Sample3x3MagicSquare();
        Square sample3x3 = new Sample3x3Square();
        Square anotherSample3x3 = new Sample3x3Square();

        Assert.assertNotEquals(sample3x3, sample3x3magic);
        Assert.assertEquals(sample3x3, anotherSample3x3);
    }

    @Test
    public void testRotate90Degrees() throws Exception {
        Square square = new Sample3x3Square();
        int[][] expectedRotatedData = { { 3, 6, 9 }, { 2, 5, 8 }, { 1, 4, 7 } };
        Square expectedRotatedSquare = new Square(expectedRotatedData);

        Square actualRotatedSquare = square.rotate();
        Assert.assertEquals(expectedRotatedSquare, actualRotatedSquare);
    }

    @Test
    public void testRotate180Degrees() throws Exception {
        Square square = new Sample3x3Square();
        int[][] expectedRotatedData = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
        Square expectedRotatedSquare = new Square(expectedRotatedData);

        Square actualRotatedSquare = square.rotate().rotate();
        Assert.assertEquals(expectedRotatedSquare, actualRotatedSquare);
    }

    @Test
    public void testRotate270Degrees() throws Exception {
        Square square = new Sample3x3Square();
        int[][] expectedRotatedData = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
        Square expectedRotatedSquare = new Square(expectedRotatedData);

        Square actualRotatedSquare = square.rotate().rotate().rotate();
        Assert.assertEquals(expectedRotatedSquare, actualRotatedSquare);
    }

    @Test
    public void testRotate360Degrees() throws Exception {
        Square square = new Sample3x3Square();
        Square expectedRotatedSquare = square;

        Square actualRotatedSquare = square.rotate().rotate().rotate().rotate();
        Assert.assertEquals(expectedRotatedSquare, actualRotatedSquare);
    }

    @Test
    public void testReflectAcrossY() throws Exception {
        Square square = new Sample3x3Square();
        int[][] expectedReflectedData = { { 3, 2, 1 }, { 6, 5, 4 }, { 9, 8, 7 } };
        Square expectedReflectedSquare = new Square(expectedReflectedData);

        Square actualReflectedSquare = square.reflectAcrossY();
        Assert.assertEquals(expectedReflectedSquare, actualReflectedSquare);
    }

    @Test
    public void testReflectAcrossX() throws Exception {
        Square square = new Sample3x3Square();
        int[][] expectedReflectedData = { { 7, 8, 9 }, { 4, 5, 6 }, { 1, 2, 3 } };
        Square expectedReflectedSquare = new Square(expectedReflectedData);

        Square actualReflectedSquare = square.reflectAcrossX();
        Assert.assertEquals(expectedReflectedSquare, actualReflectedSquare);
    }
}
