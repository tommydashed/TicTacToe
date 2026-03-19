package io.github.tommydashed.tictactoe.core;

public class InvalidMoveException extends RuntimeException{
    public String getUserMessage() {
        return "Invalid move.";
    }
}
