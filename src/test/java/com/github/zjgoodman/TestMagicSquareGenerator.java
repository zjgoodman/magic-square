package com.github.zjgoodman;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class TestMagicSquareGenerator {
    private final MagicSquareGenerator generator = new MagicSquareGenerator();

    @Test
    public void testGenerateSquare3x3() throws Exception {
        Square expectedSquare = new Sample3x3MagicSquare();
        Square actualSquare = generator.generateSquare(expectedSquare.size());

        Assert.assertEquals(actualSquare, expectedSquare);
    }

    @Test
    public void testGenerateAllSquares3x3() throws Exception {
        Set<Square> expectedSquaresSet = new HashSet<>(Arrays.asList( //
                new Square(new int[][] { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } }), //
                new Square(new int[][] { { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } }), //
                new Square(new int[][] { { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } }), //
                new Square(new int[][] { { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } }), //
                new Square(new int[][] { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } }), //
                new Square(new int[][] { { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } }), //
                new Square(new int[][] { { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } }), //
                new Square(new int[][] { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } })));
        Assert.assertTrue("Expected data contains invalid squares",
                expectedSquaresSet.stream().allMatch(Square::isMagicSquare));
        Set<Square> actualSquaresSet = generator.generateAllSquares(3);
        Assert.assertEquals(expectedSquaresSet, actualSquaresSet);
    }

    @Test
    public void testGenerateSquare5x5() throws Exception {
        try {
            generator.generateSquare(5);
            Assert.fail("expected to fail");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
