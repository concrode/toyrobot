package com.au.yuntian.entry;

import com.au.yuntian.exception.RobotException;
import com.au.yuntian.model.Robot;
import com.au.yuntian.model.RobotBoard;
import com.au.yuntian.service.Game;
import com.au.yuntian.utils.Command;
import com.au.yuntian.utils.Direction;
import com.au.yuntian.utils.Parser;
import com.au.yuntian.utils.Prompt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * This is the entry point for robot game.
 *
 * @author Yuntian
 */
public class Entry {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean running = true;

        Prompt.getWelcomeToTheGamePrompt();
        Game game = initGame();

        while (running) {
            try {
                String input = reader.readLine();

                if (Command.EXIT == Parser.getActionCommand(input)) {
                    running = false;
                    break;
                } else {
                    List<String> output = game.executeCommand(input);
                    System.out.println(formatOutput(output));
                }

             } catch (RobotException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Create game with new Robot and new RobotBoard
     *
     * @return
     */
    private static Game initGame() {
        return new Game(new Robot("Toy Robot"), new RobotBoard(4, 4, "Toy Robot Board"));
    }

    /**
     * Remove ","
     * Remove "["
     * Remove "]"
     *
     * @param output
     * @return
     */
    private static String formatOutput(List<String> output) {
        return output.toString().replace(",", "")
                .replace("[", "")
                .replace("]", "");
    }

}
