package io.github.tommydashed.tictactoe.core;


import io.github.tommydashed.tictactoe.cli.OutputHandler;

public class Game {
    private final Grid grid;

    public Game() {
        this.grid = new Grid(3);
    }

    public void makeMove(int row, int col) throws InvalidMoveException {
        grid.attemptMove(row - 1, col - 1);
    }
    public String render() {
        return grid.renderedGrid();
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
            return OutputHandler.draw();
        }
        if (isXWin()) {
            return OutputHandler.xWin();
        }
        if (isOWin()) {
            return OutputHandler.oWin();
        }
        return OutputHandler.notFinished();
    }
}
