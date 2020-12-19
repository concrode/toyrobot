import com.au.yuntian.model.Position;
import com.au.yuntian.utils.Direction;
import org.junit.Assert;
import org.junit.Test;

public class PositionTest {

    @Test
    public void testGetNewPosition () {
        Position position = new Position(1, 2, Direction.EAST);
        // (1,2,EAST) -> (2,2,EAST)
        Position newPosition = position.getNewPosition();
        Assert.assertEquals(newPosition.getX(), 2);
        Assert.assertEquals(newPosition.getY(), 2);
        Assert.assertEquals(newPosition.getDirection(), Direction.EAST);

        Position position2 = new Position(0, 0, Direction.NORTH);
        // (0,0,NORTH) -> (0,1,NORTH)
        newPosition = position2.getNewPosition();
        Assert.assertEquals(newPosition.getX(), 0);
        Assert.assertEquals(newPosition.getY(), 1);
        Assert.assertEquals(newPosition.getDirection(), Direction.NORTH);

        Position position3 = new Position(0, 0, Direction.SOUTH);
        // (0,0,SOUTH) -> (0,-1,SOUTH)
        newPosition = position3.getNewPosition();
        Assert.assertEquals(newPosition.getX(), 0);
        Assert.assertEquals(newPosition.getY(), -1);
        Assert.assertEquals(newPosition.getDirection(), Direction.SOUTH);


        Position position4 = new Position(4, 4, Direction.EAST);
        // (4,4,EAST) -> (5,4,EAST)
        newPosition = position4.getNewPosition();
        Assert.assertEquals(newPosition.getX(), 5);
        Assert.assertEquals(newPosition.getY(), 4);
        Assert.assertEquals(newPosition.getDirection(), Direction.EAST);
    }
}
