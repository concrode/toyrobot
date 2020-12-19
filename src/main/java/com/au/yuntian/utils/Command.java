package com.au.yuntian.utils;

/**
 * The Command class contains all commands
 *
 * @author Yuntian
 */
public enum Command {
    PLACE("PLACE"),
    MOVE("MOVE"),
    LEFT("LEFT"),
    RIGHT("RIGHT"),
    REPORT("REPORT"),
    EXIT("EXIT");

    private final String command;

    Command(final String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return command;
    }
}
