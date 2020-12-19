import com.au.yuntian.exception.RobotException;
import com.au.yuntian.utils.Command;
import com.au.yuntian.utils.Parser;
import org.junit.Assert;
import org.junit.Test;

public class ParserTest {

    @Test(expected = RobotException.class)
    public void testGetActionCommandWithInvalidCommand() throws RobotException{
        String input = "hello";
        Parser.getActionCommand(input);
    }

    @Test(expected = RobotException.class)
    public void testGetActionCommandWithEmptyString() throws RobotException{
        Parser.getActionCommand("");
    }


    @Test(expected = RobotException.class)
    public void testGetActionCommandWithSpecialCharacter() throws RobotException{
        Parser.getActionCommand("**()");
    }

    @Test(expected = RobotException.class)
    public void testGetActionCommandWithNumber() throws RobotException{
        Parser.getActionCommand("12344");
    }

    @Test
    public void testGetActionCommandWithNullString() throws RobotException{
        String input = null;
        Assert.assertEquals(null, Parser.getActionCommand(input));
    }

    @Test
    public void testGetActionCommandWithPlaceCommand() throws RobotException{
        String input = "PLACE";
        Assert.assertEquals(Command.PLACE, Parser.getActionCommand(input));
    }

    @Test
    public void testGetActionCommandWithPlaceCommand2() throws RobotException{
        String input = "PLACE 1,1,EAST";
        Assert.assertEquals(Command.PLACE, Parser.getActionCommand(input));
    }

    @Test
    public void testGetActionCommandWithPlaceCommandLowerCase() throws RobotException{
        String input = "place 1,1,EAST";
        Assert.assertEquals(Command.PLACE, Parser.getActionCommand(input));
    }

    @Test
    public void testGetActionCommandWithLeftCommand() throws RobotException{
        String input = "LEFT";
        Assert.assertEquals(Command.LEFT, Parser.getActionCommand(input));
    }

    @Test
    public void testGetActionCommandWithLeftCommandUpperAndLowerCaseMix() throws RobotException{
        String input = "LeFt";
        Assert.assertEquals(Command.LEFT, Parser.getActionCommand(input));
    }

    @Test(expected = RobotException.class)
    public void testGetActionCommandWithInvalidLeftCommand() throws RobotException{
        String input = "LEFT2";
        Parser.getActionCommand(input);
    }

    @Test
    public void testGetActionCommandWithRightCommand() throws RobotException{
        String input = "RIGHT";
        Assert.assertEquals(Command.RIGHT, Parser.getActionCommand(input));
    }

    @Test
    public void testGetActionCommandWithMoveCommand() throws RobotException{
        String input = "MOVE";
        Assert.assertEquals(Command.MOVE, Parser.getActionCommand(input));
    }

    @Test
    public void testGetActionCommandWithReportCommand() throws RobotException{
        String input = "REPORT";
        Assert.assertEquals(Command.REPORT, Parser.getActionCommand(input));
    }

}
