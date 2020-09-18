package com.github.zjgoodman;

import org.junit.Assert;
import org.junit.Test;

public class MagicSquareTest {
    @Test
    public void testIsMagicSquare() throws Exception {
        Square notMagicSquare = new SampleSquare();
        MagicSquare utils = new MagicSquare();
        Assert.assertFalse(utils.isMagicSquare(notMagicSquare));

        Square magicSquare = new SampleMagicSquare();
        Assert.assertTrue(utils.isMagicSquare(magicSquare));
    }
}
