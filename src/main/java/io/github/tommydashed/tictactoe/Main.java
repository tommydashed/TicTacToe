package io.github.tommydashed.tictactoe;

public class Main {


    public static void main(String[] args) {
        Grid grid = new Grid();
        Game game = new Game(grid);
        GameService gameservice = new GameService(game);
        gameservice.play();

    }
}

