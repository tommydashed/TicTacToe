package io.github.tommydashed.tictactoe.core;

public class CellOccupiedException extends InvalidMoveException{
    @Override
    public String getUserMessage() {
        return "Invalid move. Cell is already occupied.";
    }
}
