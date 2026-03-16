package io.github.tommydashed.tictactoe;


public class Game {
   private final Grid grid;

   public Game(Grid grid) {
        this.grid = grid;
    }
    public String getBoard() {
        return grid.getGridTxt();
    }
    public void makeMove(int row, int col) {
       try {
           grid.attemptMove(row - 1, col - 1);
       } catch (IllegalArgumentException e) {
           throw new IllegalArgumentException("Move cannot be made on an occupied cell.");
       }
    }
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
