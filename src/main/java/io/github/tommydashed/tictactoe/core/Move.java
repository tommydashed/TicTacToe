package io.github.tommydashed.tictactoe.core;

public record Move(int row, int col) {
    public Move(int row, int col) {
        this.row = row - 1;
        this.col = col - 1;
    }
}
