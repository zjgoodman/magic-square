package com.github.zjgoodman;

import java.util.HashSet;
import java.util.Set;

public class MagicSquareGenerator {
    public Square generateSquare(int size) {
        if (size == 3) {
            return new Sample3x3MagicSquare(); // TODO actually generate
        } else {
            throw new IllegalArgumentException("Only size 3 is supported");
        }
    }

    public Set<Square> generateAllSquares(int size) {
        Set<Square> allSquaresSet = new HashSet<>();

        Square square = generateSquare(size);
        Square reflectX = square.reflectAcrossX();
        Square reflectY = square.reflectAcrossY();
        Square rotate = square;

        allSquaresSet.add(square);
        allSquaresSet.add(reflectY);
        allSquaresSet.add(reflectX);

        for (int i = 0; i < 3; ++i) {
            rotate = rotate.rotate();
            reflectX = rotate.reflectAcrossX();
            reflectY = rotate.reflectAcrossY();

            allSquaresSet.add(rotate);
            allSquaresSet.add(reflectX);
            allSquaresSet.add(reflectY);
        }
        return allSquaresSet;
    }
}
