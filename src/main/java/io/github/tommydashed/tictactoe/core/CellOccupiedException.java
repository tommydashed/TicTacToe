package io.github.tommydashed.tictactoe.core;

public class CellOccupiedException extends InvalidMoveException{
    public CellOccupiedException(String message) {
        super(message);
    }
}
