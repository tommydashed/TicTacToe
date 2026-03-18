package io.github.tommydashed.tictactoe.cli;
import io.github.tommydashed.tictactoe.core.Game;
import io.github.tommydashed.tictactoe.core.InvalidMoveException;

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
            output.clearScreen();
            output.showBoard(game.render());
            try {
                game.makeMove(input.readInt(), input.readInt());
            }catch (InvalidMoveException e) {
                output.showInvalidMove();
            }
        }
        output.clearScreen();
        output.showBoard(game.render());
        output.showResult(game.result());
    }

}
