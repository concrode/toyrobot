package com.au.yuntian.model;

import com.au.yuntian.utils.Direction;

/**
 * The Position class presents (x,y,direction) as robot's position
 *
 * @author Yuntian
 */
public class Position {
    private int x;
    private int y;
    private Direction direction;

    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
        this.direction = position.getDirection();
    }

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    /**
     * Rule: New position moves only one unit forward against current direction.
     *
     * Eg:
     * (1,2,NORTH) -> new:(1,3,NORTH)
     *
     * (3,0,EAST) -> new:(4,0,EAST)
     *
     * @return
     */
    public Position getNewPosition() {
        Position newPosition = new Position(this);
        switch (this.direction) {
            case NORTH:
                newPosition = new Position(this.x, this.y + 1, this.direction);
                break;
            case SOUTH:
                newPosition = new Position(this.x, this.y - 1, this.direction);
                break;
            case EAST:
                newPosition = new Position(this.x + 1, this.y, this.direction);
                break;
            case WEST:
                newPosition = new Position(this.x - 1, this.y, this.direction);
                break;
        }

        return newPosition;
    }
}
