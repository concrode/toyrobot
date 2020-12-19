package com.au.yuntian.model;

/**
 * Robot board
 *
 * @author Yuntian
 */
public class RobotBoard extends Board{
    public RobotBoard(int rows, int columns, String name) {
        this.rows = rows;
        this.columns = columns;
        this.name = name;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
