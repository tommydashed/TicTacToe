package io.github.tommydashed.tictactoe.core;

public class OutOfBoundsException extends InvalidMoveException{
    public OutOfBoundsException(String message) {
        super(message);
    }
}
