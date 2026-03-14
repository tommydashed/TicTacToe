package io.github.tommydashed.tictactoe;

public class Game {
   private final GameGrid grid;
   private GameGrid.Cell currPlayer = GameGrid.Cell.X;

   public Game(GameGrid grid) {
        this.grid = grid;
    }
    public String getBoard() {
        return grid.getGridTxt();
    }
    public void loadBoard(String input) {
        grid.fillGrid(input);
    }
    public String getState() {
        return grid.getState();
    }

    public void makeMove(int row, int col) {
        if (grid.getCell(row - 1, col - 1) != GameGrid.Cell.EMPTY) {
            throw new IllegalArgumentException("Invalid move");
        }
        else {
            grid.setCell(row - 1, col - 1, currPlayer);
        }
    }
}
