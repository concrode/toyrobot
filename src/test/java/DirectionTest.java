import com.au.yuntian.utils.Direction;
import org.junit.Assert;
import org.junit.Test;


public class DirectionTest {

    @Test
    public void testRotate() {
        Direction direction = Direction.NORTH;

        // NORTH-> rotate left -> WEST
        direction = Direction.rotate90DegreesLeft(direction);
        Assert.assertEquals(Direction.WEST, direction);

        // WEST-> rotate left -> SOUTH
        direction = Direction.rotate90DegreesLeft(direction);
        Assert.assertEquals(Direction.SOUTH, direction);

        // SOUTH-> rotate left -> EAST
        direction = Direction.rotate90DegreesLeft(direction);
        Assert.assertEquals(Direction.EAST, direction);

        // EAST-> rotate left -> NORTH
        direction = Direction.rotate90DegreesLeft(direction);
        Assert.assertEquals(Direction.NORTH, direction);

        // NORTH-> rotate right -> EAST
        direction = Direction.rotate90DegreesRight(direction);
        Assert.assertEquals(Direction.EAST, direction);

        // EAST-> rotate right -> SOUTH
        direction = Direction.rotate90DegreesRight(direction);
        Assert.assertEquals(Direction.SOUTH, direction);

        // SOUTH-> rotate right -> WEST
        direction = Direction.rotate90DegreesRight(direction);
        Assert.assertEquals(Direction.WEST, direction);

        // WEST-> rotate right -> NORTH
        direction = Direction.rotate90DegreesRight(direction);
        Assert.assertEquals(Direction.NORTH, direction);

        // left null
        Assert.assertEquals(null, Direction.rotate90DegreesLeft(null));

        // right null
        Assert.assertEquals(null, Direction.rotate90DegreesRight(null));
    }
}
