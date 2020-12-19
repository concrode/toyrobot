package com.au.yuntian.service;

import com.au.yuntian.exception.RobotException;
import com.au.yuntian.model.Board;
import com.au.yuntian.model.Position;
import com.au.yuntian.model.Robot;
import com.au.yuntian.utils.Direction;
import com.au.yuntian.utils.Command;
import com.au.yuntian.utils.Parser;
import com.au.yuntian.utils.Prompt;

import java.util.ArrayList;
import java.util.List;

/**
 * The Game class contains robot and board
 *
 * @author Yuntian
 */
public class Game {
    private Robot robot;
    private Board board;
    private List<String> output = new ArrayList<>();;

    public Game (Robot robot, Board board) {
        this.robot = robot;
        this.board = board;
    }

    /**
     * This is Game's entry function and it executes all commands
     *
     * @param input
     * @return
     * @throws RobotException
     */
    public List<String>  executeCommand(String input) throws RobotException {
        if (!validCommand(input)) {
            return null;
        }

        Command actionCommand = Parser.getActionCommand(input);
        Position position = null;

        if (Command.PLACE == actionCommand) {
            position = getPositionFromPlaceCommand(input);
        }

        output.clear();
        switch (actionCommand) {
            case PLACE:
                setRobotPosition(position);
                break;
            case MOVE:
                move();
                break;
            case LEFT:
                rotateLeft();
                break;
            case RIGHT:
                rotateRight();
                break;
            case REPORT:
                output = report();
                break;
            default:
                throw new RobotException(Prompt.getValidCommandsPrompt());
        }

        return output;
    }


    /**
     * Check if command is a valid one and for "PLACE" command, checking if it has at least 2 input String.
     *
     * Both upper and lower case valid commands are accepted.
     *
     * @param input
     * @return
     * @throws RobotException
     */
    private boolean validCommand(String input) throws RobotException {
        Command command = Parser.getActionCommand(input);

        if (Command.PLACE == command && input.split(" ").length < 2) {
            throw new RobotException(Prompt.getValidCommandsPrompt());
        }

        return true;
    }


    /**
     * Valid "PLACE" command should be in this way: PLACE 1,2,WEST
     *
     * so Position is x:1, y:2, direction:WEST
     *
     * @param input
     * @return
     * @throws RobotException
     */
    private Position getPositionFromPlaceCommand(String input) throws RobotException {
        int x,y;
        Direction robotDirection;

        String[] paramsInSecondArgs = input.split(" ")[1].split(",");
        try {
                x = Integer.parseInt(paramsInSecondArgs[0]);
                y = Integer.parseInt(paramsInSecondArgs[1]);
                robotDirection = Direction.valueOf(paramsInSecondArgs[2].toUpperCase());

            } catch (Exception e) {
                throw new RobotException(Prompt.getValidPlaceCommandErrorPrompt());
        }

        Position position = new Position(x,y,robotDirection);

        return position;
    }

    /**
     * Set robot's position on board
     *
     * @param position
     * @throws RobotException
     */
    private void setRobotPosition(Position position) throws RobotException {
        if (!robot.validPosition(position, board)) {
            throw new RobotException(Prompt.getSetRobotPositionErrorPrompt());
        }

        robot.setPosition(position);
    }

    /**
     * Robot can move only one unit forward against its current direction.
     *
     * If there is no robot or position instance, it throws an exception.
     *
     * @throws RobotException
     */
    private void move() throws RobotException{
        if (null == robot || null == robot.getPosition()) {
            throw new RobotException(Prompt.getPositionOrDirectionEmptyErrorPrompt());
        }

        Position newPosition = robot.getPosition().getNewPosition();
        if (!robot.validPosition(newPosition, this.board)) {
            throw new RobotException(Prompt.getMoveErrorPrompt());
        }

        robot.move(newPosition);
    }

    /**
     * Robot can rotate 90 degrees left
     *
     * @throws RobotException
     */
    private void rotateLeft() throws RobotException {
        robot.rotateLeft();
    }

    /**
     * Robot can rotate 90 degrees right
     *
     * @throws RobotException
     */
    private void rotateRight() throws RobotException {
        robot.rotateRight();
    }

    /**
     * Report robot's current position
     *
     * @return
     * @throws RobotException
     */
    private List<String> report() throws RobotException {
        return robot.reportPosition(board);
    }

}
