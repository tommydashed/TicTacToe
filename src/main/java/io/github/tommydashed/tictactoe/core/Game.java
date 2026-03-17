package io.github.tommydashed.tictactoe.core;


public class Game {
   private final Grid grid;

   public Game(Grid grid) {
        this.grid = grid;
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
    protected boolean result() {
        return grid.xWin() || grid.oWin() || grid.draw();
    }
}
