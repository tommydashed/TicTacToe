package io.github.tommydashed.tictactoe.core;

public class OutOfBoundsException extends InvalidMoveException{
    @Override
    public String getUserMessage() {
        return "Invalid move. Move must be in bounds.";
    }
}
