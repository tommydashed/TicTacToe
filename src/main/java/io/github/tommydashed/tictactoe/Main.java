package io.github.tommydashed.tictactoe;

import io.github.tommydashed.tictactoe.cli.InputHandler;
import io.github.tommydashed.tictactoe.cli.OutputHandler;
import io.github.tommydashed.tictactoe.core.Game;
import io.github.tommydashed.tictactoe.core.Grid;
import io.github.tommydashed.tictactoe.cli.Play;
public class Main {


    public static void main(String[] args) {
        Grid grid = new Grid();
        Game game = new Game(grid);
        OutputHandler output = new OutputHandler();
        InputHandler input = new InputHandler();
        Play play = new Play(game, output, input);
        play.start();

    }
}

