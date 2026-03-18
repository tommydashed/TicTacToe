package io.github.tommydashed.tictactoe.core;

public class CellOccupiedException extends RuntimeException{
    public CellOccupiedException(String message) {
        super(message);
    }
}
