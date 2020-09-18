package com.github.zjgoodman;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MagicSquare {
    public boolean isMagicSquare(Square square) {
        Set<Integer> rowSums = square.getRows().stream().map(this::getSum).collect(Collectors.toSet());
        Set<Integer> columnSums = square.getColumns().stream().map(this::getSum).collect(Collectors.toSet());
        Set<Integer> diagonalSums = new HashSet<>(Arrays.asList(getSum(square.getBottomLeftTopRightDiagonal()),
                getSum(square.getTopLeftBottomRightDiagonal())));

        Set<Integer> sumsUnion = rowSums;
        sumsUnion.addAll(columnSums);
        // sumsUnion.addAll(diagonalSums);

        return sumsUnion.size() == 1;
    }

    private int getSum(List<Integer> values) {
        return values.stream().reduce(0, Integer::sum);
    }
}
