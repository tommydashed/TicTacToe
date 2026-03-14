package io.github.tommydashed.tictactoe;

public class Main {


    public static void main(String[] args) {
        GameGrid grid = new GameGrid();
        Game game = new Game(grid);
        GameService gameservice = new GameService(game);
        gameservice.play();

    }
}

