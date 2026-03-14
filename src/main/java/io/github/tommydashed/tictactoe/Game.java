package io.github.tommydashed.tictactoe;

public class Game {
   private final GameGrid grid;
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
}
