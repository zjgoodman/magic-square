package com.github.zjgoodman;

public class Sample5x5MagicSquare extends Square {
    public static final int[][] SAMPLE_MAGIC_DATA = { { 17, 24, 1, 8, 15 }, { 23, 5, 7, 14, 16 }, { 4, 6, 13, 20, 22 },
            { 10, 12, 19, 21, 3 }, { 11, 18, 25, 2, 9 } };

    public Sample5x5MagicSquare() {
        super(SAMPLE_MAGIC_DATA);
    }
}
