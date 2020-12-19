package com.au.yuntian.model;

import com.au.yuntian.exception.RobotException;
import com.au.yuntian.utils.Direction;
import com.au.yuntian.utils.Prompt;
import java.util.ArrayList;
import java.util.List;

/**
 * The Robot class is the toy robot in the game
 *
 * @author Yuntian
 */
public class Robot {
    private Position position;
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Set new position to this.position
     *
     * @param newPosition
     */
    public void move (Position newPosition) {
        this.position = newPosition;
    }

    /**
     * Robot needs to rotate 90 degrees left
     *
     * @throws RobotException
     */
    public void rotateLeft() throws RobotException {
        if (null == this.position || null == this.position.getDirection()) {
            throw new RobotException(Prompt.getPositionOrDirectionEmptyErrorPrompt());
        }

        this.position.setDirection(Direction.rotate90DegreesLeft(this.position.getDirection()));
    }


    /**
     * Robot needs to rotate 90 degrees right
     *
     * @throws RobotException
     */
    public void rotateRight() throws RobotException {
        if (null == this.position || null == this.position.getDirection()) {
            throw new RobotException(Prompt.getPositionOrDirectionEmptyErrorPrompt());
        }

        this.position.setDirection(Direction.rotate90DegreesRight(this.position.getDirection()));
    }

    /**
     * Report current robot position with graph
     *
     * Output Eg:
     *              * * * * *
     *              * * * * *
     *              * < * * *
     *              * * * * *
     *              * * * * *
     *              The above map shows robot's location -> (x:1 y:2 direction:WEST). Note:(x:0 y:0) represents the SOUTH WEST most corner.
     *
     * @param board
     * @return
     * @throws RobotException
     */
    public List<String> reportPosition (Board board) throws RobotException {
        if (null == this.position) {
            throw new RobotException(Prompt.getPositionOrDirectionEmptyErrorPrompt());
        }

        // Output (i,j) starts with (4,0) -> (4,1) -> (4,2) ....
        // Row 5 in (x,y) axis starts with (0,4) -> (1,4) -> (2,4) ...
        // So i = y, j = x
        List<String> output = new ArrayList<>();
        for (int i = board.getRows(); i >= 0; i --) {
            for (int j = 0; j <= board.getColumns(); j ++) {
                if (this.position.getX() == j && this.position.getY() == i ) {
                    // Get direction icon
                    output.add(Direction.valueOf(
                            this.position.getDirection().name() + "_ICON").toString()) ;
                } else {
                    output.add("*");
                }

                // Add "\n" only for printing line change
                if (0 == j) {
                    output.set(output.size()-1, "\n" + output.get(output.size()-1));
                }

            }
        }

        output.add("\nThe above map shows robot's location -> (x:" + this.position.getX() + ", y:" + this.position.getY() +
                ", direction:" + this.position.getDirection().name() + "). Note:(x:0 y:0) represents the SOUTH WEST most corner.\n" );

        return output;
    }


    /**
     * Check if position is valid or not.
     *
     * Return false if position is exceeding the board's boundary.
     *
     * @param position
     * @param board
     * @return
     */
    public boolean validPosition(Position position, Board board) {
        if (null == position || null == board) {
            return false;
        }

        return !(
                position.getX() > board.getRows()|| position.getX() < 0 ||
                        position.getY() > board.getColumns() || position.getY() < 0
        );
    }

}
