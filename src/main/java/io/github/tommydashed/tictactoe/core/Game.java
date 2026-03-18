package io.github.tommydashed.tictactoe.core;


public class Game {
    private final Grid grid;

    public Game() {
        this.grid = new Grid(3);
    }

    public void makeMove(int row, int col) {
       try {
           grid.attemptMove(row - 1, col - 1);
       } catch (OutOfBoundsException e) {
           throw new OutOfBoundsException("Move cannot be made out of bounds.");
       } catch (CellOccupiedException e) {
           throw new CellOccupiedException("Cell is already occupied.");
       }
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
