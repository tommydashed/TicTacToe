package io.github.tommydashed.tictactoe.core;

public class InvalidMoveException extends RuntimeException{
    public InvalidMoveException(String message) {
        super(message);
    }
}
