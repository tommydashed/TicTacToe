package io.github.tommydashed.tictactoe;

public class Game {
   private final GameGrid grid;
   private Cell currPlayer = Cell.X;

   public Game(GameGrid grid) {
        this.grid = grid;
    }
    public String getBoard() {
        return grid.getGridTxt();
    }
    public GameState state() {
        return grid.getState();
    }
    public void makeMove(int row, int col) {
        if (grid.getCell(row - 1, col - 1) != Cell.EMPTY) {
            throw new IllegalArgumentException("Invalid move");
        }
        else {
            grid.setCell(row - 1, col - 1, currPlayer);
        }
    }
    public void switchPlayer() {
       currPlayer = currPlayer == Cell.X ? Cell.O : Cell.X;
    }
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
