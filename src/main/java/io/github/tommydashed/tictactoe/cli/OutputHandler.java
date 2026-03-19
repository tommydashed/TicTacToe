package io.github.tommydashed.tictactoe.cli;

import io.github.tommydashed.tictactoe.core.InvalidMoveException;

public class OutputHandler {
    public void print(String message) {
        System.out.println(message);
    }
    public void showBoard(String board) {
        System.out.println(board);
    }
    public void showResult(String result) {
        System.out.println(result);
    }
    public void showInvalidMove(InvalidMoveException e) {
        System.out.println(e.getUserMessage());
    }
    public void showInvalidInput() {
        System.out.println("Invalid input. Must be a number between 1 and 3.");
    }
    public static String xWin() {
        return "X wins!";
    }
    public static String oWin() {
        return "O wins!";
    }
    public static String draw() {
       return "It's a draw!";
    }
    public static String notFinished() {
        return "Game not finished.";
    }
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
