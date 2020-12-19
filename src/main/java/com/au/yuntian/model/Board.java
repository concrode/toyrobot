package com.au.yuntian.model;

/**
 * Generic Board
 *
 * @author Yuntian
 */
public abstract class Board {
    protected int rows;
    protected int columns;
    protected String name;

    public Board(){};

    public abstract int getRows();

    public abstract int getColumns();

}
