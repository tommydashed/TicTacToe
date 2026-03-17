package io.github.tommydashed.tictactoe.cli;
import io.github.tommydashed.tictactoe.core.Game;

public class TicTacToe {
    private final Game game;
    private final OutputHandler output;
    private final InputHandler input;

    public TicTacToe(Game game, OutputHandler output, InputHandler input) {
        this.game = game;
        this.output = output;
        this.input = input;
    }

    public void start() {
        while (!game.isFinished()) {
            game.clearScreen();
            output.showBoard(game.render());
            game.makeMove(input.readInt(), input.readInt());
        }
        game.clearScreen();
        output.showBoard(game.render());
        output.showResult(game.result());
    }

}
