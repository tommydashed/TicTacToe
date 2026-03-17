package io.github.tommydashed.tictactoe;

import io.github.tommydashed.tictactoe.cli.InputHandler;
import io.github.tommydashed.tictactoe.cli.OutputHandler;
import io.github.tommydashed.tictactoe.core.Game;
import io.github.tommydashed.tictactoe.cli.TicTacToe;
public class Main {


    public static void main(String[] args) {
        Game game = new Game();
        OutputHandler output = new OutputHandler();
        InputHandler input = new InputHandler();
        TicTacToe play = new TicTacToe(game, output, input);
        play.start();

    }
}

