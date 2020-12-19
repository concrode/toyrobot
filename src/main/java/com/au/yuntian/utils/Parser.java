package com.au.yuntian.utils;

import com.au.yuntian.exception.RobotException;

/**
 * If input is "place 3,3,WEST", then return "place" as an action command.
 *
 * If input is "left", then return "left" as an action command.
 *
 * If input is an invalid command or number or special character, then throw an exception.
 *
 * @author Yuntian
 */
public class Parser {

    public static Command getActionCommand(String input) throws RobotException {
        if(null == input) {
            return null;
        }

        try {
           return Command.valueOf(input.split(" ")[0].toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RobotException(Prompt.getValidCommandsPrompt());
        }
    }
}
