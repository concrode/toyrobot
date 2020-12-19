import com.au.yuntian.exception.RobotException;
import com.au.yuntian.model.Position;
import com.au.yuntian.model.Robot;
import com.au.yuntian.utils.Direction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RobotTest {

    Robot robot;
    Position position;

    @Before
    public void setup() {
       robot  = new Robot("MyRobot");;
       position = new Position(1, 1, Direction.NORTH);
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
    public void testReport() {


    }

}
