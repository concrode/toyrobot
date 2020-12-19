import com.au.yuntian.exception.RobotException;
import com.au.yuntian.model.Board;
import com.au.yuntian.model.Position;
import com.au.yuntian.model.Robot;
import com.au.yuntian.model.RobotBoard;
import com.au.yuntian.service.Game;
import com.au.yuntian.utils.Direction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameTest {

    Robot robot;
    Board board;
    Position position;
    Game game;
    List<String> reportOutput;

    @Before
    public void setup() {
        robot = new Robot("MyRobot");
        board = new RobotBoard(4,4, "MyRobotBoard");
        game = new Game(robot, board);
        reportOutput = new ArrayList<>(Arrays.asList(
                "\n*", "*", "*", "*", "*",
                "\n*", "*", "*", "*", "*",
                "\n*", ">", "*", "*", "*",
                "\n*", "*", "*", "*", "*",
                "\n*", "*", "*", "*", "*",
                "\nThe above map shows robot's location -> " +
                        "(x:1, y:2, direction:EAST). Note:(x:0 y:0) " +
                        "represents the SOUTH WEST most corner.\n"));

    }


    @Test
    public void testExecuteCommand() throws RobotException{
        String place = "PLACE 2,3,WEST";
        game.executeCommand(place);

        position = new Position(2,3, Direction.WEST);
        Assert.assertEquals(position.toString(), robot.getPosition().toString());

        // (1,3,WEST)
        String move = "MOVE";
        game.executeCommand(move);

        // (1,3,SOUTH)
        String left = "LEFT";
        game.executeCommand(left);

        // (1,2,SOUTH)
        game.executeCommand(move);

        // (1,2,EAST)
        String right = "right";
        game.executeCommand(right);
        game.executeCommand(right);
        game.executeCommand(right);

        String report = "report";
        game.executeCommand(report);

        Assert.assertEquals(reportOutput, robot.reportPosition(board));
    }

}
