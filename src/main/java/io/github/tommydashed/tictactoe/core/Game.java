package io.github.tommydashed.tictactoe.core;


public class Game {
    private final Grid grid;

    public Game() {
        this.grid = new Grid(3);
    }

    public void makeMove(int row, int col) {
       try {
           grid.attemptMove(row - 1, col - 1);
       } catch (IllegalArgumentException e) {
           throw new IllegalArgumentException("Move cannot be made on an occupied cell.");
       }
    }
    public String render() {
        return grid.renderedGrid();
    }
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public boolean isFinished() {
        return grid.gameFinished();
    }
    private boolean isDraw() {
        return grid.result() == Grid.GridState.DRAW;
    }
    private boolean isXWin() {
        return grid.result() == Grid.GridState.X_WIN;
    }
    private boolean isOWin() {
        return grid.result() == Grid.GridState.O_WIN;
    }
    public String result() {
        if (isDraw()) {
            return "It's a draw!";
        }
        if (isXWin()) {
            return "X wins!";
        }
        if (isOWin()) {
            return "O wins!";
        }
        return "Game not finished yet.";
    }
}
