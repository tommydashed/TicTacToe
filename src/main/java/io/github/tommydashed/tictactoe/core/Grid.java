package io.github.tommydashed.tictactoe.core;

import java.util.Arrays;

public class Grid {

    enum GridState {
        DRAW, X_WIN, O_WIN, NOT_FINISHED
    }

    private enum Cell {
        EMPTY, X, O
    }

    private final Cell[][] grid;

    public Grid() {
        int size = 3;
        grid = new Cell[size][size];
       for (Cell[] row : grid) {
           Arrays.fill(row, Cell.EMPTY);
       }
    }
    private Cell currentPlayer () {
        int xCount = 0;
        int oCount = 0;
        for (Cell[] row : grid) {
            for (Cell col : row) {
                if (col == Cell.X) {
                    xCount++;
                } else if (col == Cell.O) {
                    oCount++;
                }
            }
        }
       return xCount == oCount ? Cell.X : Cell.O;
    }
    private Cell lastPlayer() {
        return currentPlayer() == Cell.X ? Cell.O : Cell.X;
    }

    private GridState state(Cell player) {
        if (isRowWin(player) || isColWin(player) || isDiagonalWin(player) || isAntiDiagonalWin(player)) {
            return winFor(player);
        }
        if (gridHasEmpty()) {
            return GridState.NOT_FINISHED;
        }
        return GridState.DRAW;
    }
    public

    String renderedGrid() {
        StringBuilder gridBuilder = new StringBuilder();
        gridBuilder.append("-".repeat(9));
        gridBuilder.append('\n');
        for (int i = 0; i < 3; i++) {
            gridBuilder.append("| ");
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == Cell.EMPTY) {
                    gridBuilder.append("  ");
                    continue;
                }
                gridBuilder.append(grid[i][j]).append(" ");
            }
            gridBuilder.append("|");
            gridBuilder.append('\n');
        }
        gridBuilder.append("-".repeat(9));
        return gridBuilder.toString();
    }
    private GridState winFor(Cell player) {
        return player == Cell.X ? GridState.X_WIN : GridState.O_WIN;
    }
    private void setCell(int row, int col, Cell player) {
        grid[row][col] = player == Cell.X ? Cell.X : Cell.O;
    }
    public boolean isCellEmpty(int row, int col) {
        return grid[row][col] == Cell.EMPTY;
    }
    public boolean gridHasEmpty() {
        boolean empty = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (isCellEmpty(i, j)) {
                    empty = true;
                    break;
                }
            }
        }
        return empty;
    }

    public void attemptMove(int row, int col) {
        if (isCellEmpty(row, col)) {
            setCell(row, col, currentPlayer());
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    private boolean isDiagonalWin(Cell player) {
        int size = grid.length;
        int diagCount = 0;
        for (int i = 0; i < size; i++) {
            diagCount = grid[i][i] == player ? diagCount + 1 : diagCount;
        }
        return diagCount == size;
    }
    private boolean isAntiDiagonalWin(Cell player) {
        int size = grid.length;
        int antiDiagCount = 0;
        for (int i = 0, j = (size - 1); i < size && j >=0; i++, j--)
            antiDiagCount = grid[i][j] == player ? antiDiagCount + 1 : antiDiagCount;
        return antiDiagCount == size;
    }
    private boolean isRowWin(Cell player) {
        Cell[] check = new Cell[]{player, player, player};
        for (Cell[] row : grid) {
            if (Arrays.equals(row, check)) {
                return true;
            }
        }
        return false;
    }
    private boolean isColWin(Cell player) {
        for (Cell[] cells : grid) {
            if (cells[0] == player && cells[1] == player && cells[2] == player) {
                return true;
            }
        }
        return false;
    }
}