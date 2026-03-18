package io.github.tommydashed.tictactoe.cli;

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
    public void showInvalidMove() {
        System.out.println("Invalid move. Try again.");
    }
    public void xWin() {
        System.out.println("X wins!");
    }
    public void oWin() {
        System.out.println("O wins!");
    }
    public void draw() {
        System.out.println("It's a draw!");
    }
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
