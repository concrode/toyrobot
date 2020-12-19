package com.au.yuntian.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * The Direction class represents four directions.
 *
 * @author Yuntian
 */
public enum Direction {
    NORTH("NORTH"),
    SOUTH("SOUTH"),
    EAST("EAST"),
    WEST("WEST"),

    // This is the icon used for printing out the robot's direction in graph
    NORTH_ICON("^"),
    SOUTH_ICON("V"),
    EAST_ICON(">"),
    WEST_ICON("<");

    private static final Map<String, String> leftTable;
    private static final Map<String, String> rightTable;
    static {
        leftTable = new HashMap<>();
        leftTable.put("NORTH", "WEST");
        leftTable.put("WEST", "SOUTH");
        leftTable.put("SOUTH", "EAST");
        leftTable.put("EAST", "NORTH");

        rightTable = new HashMap<>();
        rightTable.put("NORTH", "EAST");
        rightTable.put("EAST", "SOUTH");
        rightTable.put("SOUTH", "WEST");
        rightTable.put("WEST", "NORTH");
    }

    private final String direction;

    Direction(final String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return direction;
    }

    /**
     * Rotate 90 degrees left on current direction, then returns a new direction
     *
     * @param direction
     * @return
     */
    public static Direction rotate90DegreesLeft(Direction direction) {
        return direction == null? null :Direction.valueOf(leftTable.get(direction.name()));
    }

    /**
     * Rotate 90 degrees right on current direction, then returns a new direction
     *
     * @param direction
     * @return
     */
    public static Direction rotate90DegreesRight(Direction direction) {
        return direction == null? null : Direction.valueOf(rightTable.get(direction.name()));
    }
}

