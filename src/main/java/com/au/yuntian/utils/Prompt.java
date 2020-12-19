package com.au.yuntian.utils;

/**
 * The Prompt class provides prompts within the game
 *
 * @author Yuntian
 */
public class Prompt {

    private final static String WELCOME_TO_THE_GAME = "====> Welcome to the game <=====";
    private final static String INTRODUCTION_BOARD = "This is a 5 units * 5 units square board.";
    private final static String INTRODUCTION_ROBOT_MOVE_RULES = "The robot is free to roam around the surface of the table, " +
            "but must be prevented from falling to destruction.";
    private final static String INTRODUCTION_ROBOT_PLACE_RULES = "The robot can only move within the board after you place it " +
            "firstly.";
    private final static String VALID_COMMANDS = "Rules: Valid commands are:" +
            "PLACE X,Y,NORTH|SOUTH|EAST|WEST, MOVE, LEFT, RIGHT, REPORT or EXIT\n";
    private final static String EXAMPLE_INPUT = "#Example Commands:\n"
        + "PLACE 1,2,EAST\n" +
            "MOVE\n" +
            "MOVE\n" +
            "LEFT\n" +
            "MOVE\n" +
            "REPORT\n" +
            "Output: 3,3,NORTH\n" +
            "====================>" +
            "Please enter command" +
            "<====================";
    private final static String REPORT_COMMAND = "After you enter REPORT command, robot's position will be printed out as output.";
    private final static String VALID_PLACE_COMMAND_ERROR_PROMPT = "Error: Valid PLACE COMMAND -> PLACE X,Y,NORTH|SOUTH|EAST|WEST -> " +
            "Eg: PLACE 1,2,EAST\n";
    private final static String POSITION_OR_DIRECTION_EMPTY_ERROR_PROMPT = "Error: Robot's position or direction is empty.\n";
    private final static String MOVE_ERROR_PROMPT = "Error: Please check your current position before moving.\n";
    private final static String SET_ROBOT_POSITION_ERROR_PROMPT = "This is a 5 units * 5 units square board and (0,0) " +
            "represents the SOUTH WEST most corner.\n";


    /**
     * Welcome prompts
     *
     */
    public static void getWelcomeToTheGamePrompt() {
        System.out.println(WELCOME_TO_THE_GAME);
        System.out.println(INTRODUCTION_BOARD);
        System.out.println(INTRODUCTION_ROBOT_MOVE_RULES);
        System.out.println(INTRODUCTION_ROBOT_PLACE_RULES);
        System.out.println(REPORT_COMMAND);
        System.out.println(VALID_COMMANDS);
        System.out.println(EXAMPLE_INPUT);
    }

    /**
     * Return valid commands prompt
     *
     * @return
     */
    public static String getValidCommandsPrompt() {
        return VALID_COMMANDS;
    }

    /**
     * Return valid place command prompt
     *
     * @return
     */
    public static String getValidPlaceCommandErrorPrompt() {
        return VALID_PLACE_COMMAND_ERROR_PROMPT;
    }

    /**
     * Return position or direction empty error prompt
     *
     * @return
     */
    public static String getPositionOrDirectionEmptyErrorPrompt() {return POSITION_OR_DIRECTION_EMPTY_ERROR_PROMPT;}

    /**
     * Return move error prompt
     *
     * @return
     */
    public static String getMoveErrorPrompt() {return MOVE_ERROR_PROMPT;}

    /**
     * Return set robot position error prompt
     *
     * @return
     */
    public static String getSetRobotPositionErrorPrompt() {return SET_ROBOT_POSITION_ERROR_PROMPT;}
}
