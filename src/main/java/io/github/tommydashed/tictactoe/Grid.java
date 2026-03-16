package io.github.tommydashed.tictactoe;

import java.util.Arrays;

public class Grid {

    private enum GridState {
        DRAW, X_WIN, O_WIN, IMPOSSIBLE, NOT_FINISHED
    }

    public enum Cell {
        EMPTY, X, O
    }

    private final Cell[][] grid;
    private Cell player = Cell.X;

    public Grid() {
        int size = 3;
        grid = new Cell[size][size];
       for (Cell[] row : grid) {
           Arrays.fill(row, Cell.EMPTY);
       }
    }

    private GridState getState() {
        boolean x_win = false;
        boolean o_win = false;
        int colCount = 0;
        int rowCount = 0;
        int diagCount = 0;
        int antiDiagCount = 0;
        int totalCount = 0;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                colCount = grid[j][i] == Cell.X ? colCount + 1
                        : grid[j][i] == Cell.O ? colCount - 1 : colCount;
                rowCount = grid[i][j] == Cell.X ? rowCount + 1
                        : grid[i][j] == Cell.O ? rowCount - 1 : rowCount;
                if (rowCount == 3) {
                    x_win = true;
                }
                if (rowCount == -3) {
                    o_win = true;
                }
                if (colCount == -3) {
                    o_win = true;
                }
                if (colCount == 3) {
                    x_win = true;
                }
            }
            totalCount += rowCount;
            colCount = 0;
            rowCount = 0;

        }
        for (int i = 0, j = 2; i < 3 && j >= 0; i++, j--) {
            diagCount = grid[i][i] == Cell.X ? diagCount + 1
                    : grid[i][i] == Cell.O ? diagCount - 1 : diagCount;
            if (diagCount == 3) {
                x_win = true;
            }
            if (diagCount == -3) {
                o_win = true;
            }
            antiDiagCount = grid[i][j] == Cell.X ? antiDiagCount + 1
                    : grid[i][j] == Cell.O ? antiDiagCount - 1 : antiDiagCount;
            if (antiDiagCount == 3) {
                x_win = true;
            }
            if (antiDiagCount == -3) {
                o_win = true;
            }
        }
        if ((x_win && o_win) || (totalCount < -1 || totalCount > 1)) {
            return GridState.IMPOSSIBLE;
        } else if (x_win) {
            return GridState.X_WIN;
        } else if (o_win) {
            return GridState.O_WIN;
        } else if (isGridEmpty()) {
            return GridState.DRAW;
        } else {
            return GridState.NOT_FINISHED;
        }
    }

    public String getGridTxt() {
        StringBuilder gridTxtBuilder = new StringBuilder();
        gridTxtBuilder.append("-".repeat(9));
        gridTxtBuilder.append('\n');
        for (int i = 0; i < 3; i++) {
            gridTxtBuilder.append("| ");
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == Cell.EMPTY) {
                    gridTxtBuilder.append("  ");
                    continue;
                }
                gridTxtBuilder.append(grid[i][j]).append(" ");
            }
            gridTxtBuilder.append("|");
            gridTxtBuilder.append('\n');
        }
        gridTxtBuilder.append("-".repeat(9));
        return gridTxtBuilder.toString();
    }

    private void setCell(int row, int col, Cell player) {
        grid[row][col] = player == Cell.X ? Cell.X : Cell.O;
    }
    public boolean isCellEmpty(int row, int col) {
        return grid[row][col] != Cell.EMPTY;
    }
    public boolean isGridEmpty() {
        boolean empty = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isCellEmpty(i, j)) {
                    empty = false;
                }
            }
        }
        return empty;
    }
    public void switchPlayer() {
        player = player == Cell.X ? Cell.O : Cell.X;
    }
    public void attemptMove(int row, int col) {
        if (!isCellEmpty(row, col)) {
            setCell(row, col, player);
            switchPlayer();
        }
        else {
            throw new IllegalArgumentException();
        }
        getState();
    }
}