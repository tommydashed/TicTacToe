package io.github.tommydashed.tictactoe.cli;
import io.github.tommydashed.tictactoe.core.Game;

import java.util.InputMismatchException;

public class Play {
    private final Game game;
    private final OutputHandler output;
    private final InputHandler input;

    public Play(Game game, OutputHandler output, InputHandler input) {
        this.game = game;
        this.output = output;
        this.input = input;
    }

    public void start() {

    }
}
