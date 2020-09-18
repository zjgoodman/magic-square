package com.github.zjgoodman;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Square {
    private static final int MINIMUM_SIZE = 3;

    private final List<List<Integer>> rows;

    public Square(int[][] data) {
        this(arrayToList(data));
    }

    public Square(List<List<Integer>> data) {
        if (!isSquare(data)) {
            throw new IllegalArgumentException("Input is not a square");
        }
        this.rows = data;
    }

    public int getValue(int row, int column) {
        return rows.get(row).get(column);
    }

    public String toString() {
        return rows.stream().map(List::toString).collect(Collectors.joining("\n"));
    }

    private static List<List<Integer>> arrayToList(int[][] array) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] rowArray : array) {
            List<Integer> rowList = new ArrayList<>();
            for (int value : rowArray) {
                rowList.add(value);
            }
            list.add(rowList);
        }
        return list;
    }

    private static boolean isSquare(List<List<Integer>> rows) {
        int columnSize = rows.size();
        Predicate<? super List<Integer>> isRowSameSizeAsColumns = row -> row.size() == columnSize;
        return columnSize >= MINIMUM_SIZE && rows.stream().allMatch(isRowSameSizeAsColumns);
    }

    public int size() {
        return rows.size();
    }
}
