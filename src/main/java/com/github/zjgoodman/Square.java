package com.github.zjgoodman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public List<List<Integer>> getRows() {
        return rows;
    }

    public List<List<Integer>> getColumns() {
        List<List<Integer>> columns = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            List<Integer> column = getColumn(i);
            columns.add(column);
        }
        return columns;
    }

    public List<Integer> getRow(int row) {
        // TODO check bounds
        return rows.get(row);
    }

    public List<Integer> getColumn(int column) {
        // TODO check bounds
        return rows.stream().map(row -> row.get(column)).collect(Collectors.toList());
    }

    public List<Integer> getTopLeftBottomRightDiagonal() {
        List<Integer> values = new ArrayList<>();
        for (int index = 0; index < size(); ++index) {
            values.add(getValue(index, index));
        }
        return values;
    }

    public List<Integer> getBottomLeftTopRightDiagonal() {
        List<Integer> values = new ArrayList<>();
        int row = size() - 1;
        int column = 0;
        while (row >= 0 && column < size()) {
            values.add(getValue(row--, column++));
        }
        return values;
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

    public boolean isMagicSquare() {
        Set<Integer> rowSums = getRows().stream().map(this::getSum).collect(Collectors.toSet());
        Set<Integer> columnSums = getColumns().stream().map(this::getSum).collect(Collectors.toSet());
        Set<Integer> diagonalSums = new HashSet<>(
                Arrays.asList(getSum(getBottomLeftTopRightDiagonal()), getSum(getTopLeftBottomRightDiagonal())));

        Set<Integer> sumsUnion = rowSums;
        sumsUnion.addAll(columnSums);
        sumsUnion.addAll(diagonalSums);

        return sumsUnion.size() == 1;
    }

    private int getSum(List<Integer> values) {
        return values.stream().reduce(0, Integer::sum);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Square) {
            Square otherSquare = (Square) other;
            return this.rows.equals(otherSquare.rows);
        }
        return false;
    }

    public Square rotate() {
        List<List<Integer>> columns = getColumns();
        Collections.reverse(columns);
        return new Square(columns);
    }
}
