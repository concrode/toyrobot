import com.au.yuntian.exception.RobotException;
import com.au.yuntian.model.Board;
import com.au.yuntian.model.Position;
import com.au.yuntian.model.Robot;
import com.au.yuntian.model.RobotBoard;
import com.au.yuntian.utils.Direction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RobotTest {

    Robot robot;
    Position position;
    Board board;

    @Before
    public void setup() {
       robot  = new Robot("MyRobot");
       position = new Position(1, 1, Direction.NORTH);
       board = new RobotBoard(4,4, "MyRobotBoard");
       robot.setPosition(position);
    }

    @Test
    public void testMove() {
        // newPosition (1,2,NORTH)
        Position newPosition = position.getNewPosition();
        robot.move(newPosition);

        Assert.assertEquals(newPosition, robot.getPosition());
        Assert.assertEquals(1, robot.getPosition().getX());
        Assert.assertEquals(2, robot.getPosition().getY());
        Assert.assertEquals(Direction.NORTH, robot.getPosition().getDirection());
    }

    @Test
    public void testRotateLeft() throws RobotException{
        robot.rotateLeft();
        Assert.assertEquals(Direction.WEST, robot.getPosition().getDirection());
    }

    @Test (expected = RobotException.class)
    public void testRotateLeftWithEmptyPosition() throws RobotException{
        robot.setPosition(null);
        robot.rotateLeft();
    }

    @Test (expected = RobotException.class)
    public void testRotateLeftWithEmptyDirection() throws RobotException{
        robot.getPosition().setDirection(null);
        robot.rotateLeft();
    }

    @Test
    public void testRotateRight() throws RobotException{
        robot.rotateRight();
        Assert.assertEquals(Direction.EAST, robot.getPosition().getDirection());
    }

    @Test (expected = RobotException.class)
    public void testRotateRightWithEmptyPosition() throws RobotException{
        robot.setPosition(null);
        robot.rotateRight();
    }

    @Test (expected = RobotException.class)
    public void testRotateRightWithEmptyDirection() throws RobotException{
        robot.getPosition().setDirection(null);
        robot.rotateRight();
    }

    @Test
    public void testValidPosition() {
        Assert.assertTrue(robot.validPosition(position, board));
    }

    @Test
    public void testValidPositionWithBoundary1() {
        Position position = new Position(0, 0, Direction.EAST);
        Assert.assertTrue(robot.validPosition(position, board));
    }


    @Test
    public void testValidPositionWithBoundary2() {
        Position position = new Position(4, 4, Direction.EAST);
        Assert.assertTrue(robot.validPosition(position, board));
    }


    @Test
    public void testValidPositionWithBoundary3() {
        Position position = new Position(0, 4, Direction.WEST);
        Assert.assertTrue(robot.validPosition(position, board));
    }


    @Test
    public void testValidPositionWithBoundary4() {
        Position position = new Position(4, 0, Direction.EAST);
        Assert.assertTrue(robot.validPosition(position, board));
    }

    @Test
    public void testValidPositionWithInvalidPosition1() {
        Position position = new Position(0, -1, Direction.EAST);
        Assert.assertFalse(robot.validPosition(position, board));
    }

    @Test
    public void testValidPositionWithInvalidPosition2() {
        Position position = new Position(5, 0, Direction.EAST);
        Assert.assertFalse(robot.validPosition(position, board));
    }

    @Test
    public void testValidPositionWithInvalidPosition3() {
        Position position = new Position(5, 5, Direction.EAST);
        Assert.assertFalse(robot.validPosition(position, board));
    }

    @Test
    public void testValidPositionWithInvalidPosition4() {
        Position position = new Position(0, 5, Direction.EAST);
        Assert.assertFalse(robot.validPosition(position, board));
    }


    @Test
    public void testValidPositionWithNullPosition() {
        position = null;
        Assert.assertFalse(robot.validPosition(position, board));
    }


    @Test
    public void testValidPositionWithNullBoard() {
        board = null;
        Assert.assertFalse(robot.validPosition(position, board));
    }

    @Test
    public void testReport() throws RobotException{
        List<String> output = new ArrayList<>(Arrays.asList(
                "\n*", "*", "*", "*", "*",
                "\n*", "*", "*", "*", "*",
                "\n*", ">", "*", "*", "*",
                "\n*", "*", "*", "*", "*",
                "\n*", "*", "*", "*", "*",
                "\nThe above map shows robot's location -> (x:1, y:2, direction:EAST). Note:(x:0 y:0) represents the SOUTH WEST most corner.\n"));

        robot.setPosition(new Position(1,2,Direction.EAST));
        Assert.assertEquals(output, robot.reportPosition(board));

    }

}
