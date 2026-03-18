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
    private final int size;

    public Grid(int size) {
        this.size = size;
        grid = new Cell[size][size];
       for (Cell[] row : grid) {
           Arrays.fill(row, Cell.EMPTY);
       }
    }

    public String renderedGrid() {
        StringBuilder gridBuilder = new StringBuilder();
        gridBuilder.append("-".repeat(9));
        gridBuilder.append('\n');
        for (int i = 0; i < size; i++) {
            gridBuilder.append("| ");
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == Cell.EMPTY) {
                    gridBuilder.append("  ");
                    continue;
                }
                gridBuilder.append(grid[i][j]).append(" ");
            }
            gridBuilder.append("|");
            gridBuilder.append('\n');
        }
        gridBuilder.append("-".repeat(size * 3));
        return gridBuilder.toString();
    }

    private void setCell(int row, int col, Cell player) {
        grid[row][col] = player == Cell.X ? Cell.X : Cell.O;
    }
    public boolean cellIsEmpty(int row, int col) {
        return grid[row][col] == Cell.EMPTY;
    }
    public boolean gridHasEmpty() {
        boolean empty = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cellIsEmpty(i, j)) {
                    empty = true;
                    break;
                }
            }
        }
        return empty;
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
    private boolean isDiagonalWin(Cell player) {
        int diagCount = 0;
        for (int i = 0; i < size; i++) {
            diagCount = grid[i][i] == player ? diagCount + 1 : diagCount;
        }
        return diagCount == size;
    }
    private boolean isAntiDiagonalWin(Cell player) {
        int antiDiagCount = 0;
        for (int i = 0, j = (size - 1); i < size && j >=0; i++, j--)
            antiDiagCount = grid[i][j] == player ? antiDiagCount + 1 : antiDiagCount;
        return antiDiagCount == size;
    }
    private boolean isRowWin(Cell player) {
        Cell[] check = new Cell[size];
        Arrays.fill(check, player);
        for (Cell[] row : grid) {
            if (Arrays.equals(row, check)) {
                return true;
            }
        }
        return false;
    }
    private boolean isColWin(Cell player) {
        boolean isWin = false;
        for (int i = 0; i < size; i++) {
            isWin = true;
            for (int j = 0; j < size; j++) {
                if (grid[j][i] != player) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                break;
            }
       }
        return isWin;
    }
    private GridState winFor(Cell player) {
        return player == Cell.X ? GridState.X_WIN : GridState.O_WIN;
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

    public void attemptMove(int row, int col) throws InvalidMoveException{
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            throw new OutOfBoundsException("Invalid move. Move must be between 1 and 3.");
        }
        else if (!cellIsEmpty(row, col)) {
            throw new CellOccupiedException("Cell is already occupied.");
        }
        else {
            setCell(row, col, currentPlayer());
        }
    }

    public boolean gameFinished() {
        return state(lastPlayer()) != GridState.NOT_FINISHED;
    }
    GridState result() {
        return state(lastPlayer());
    }
}