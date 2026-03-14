package io.github.tommydashed.tictactoe;

public class GameGrid {
    enum Cell {
        EMPTY, X, O
    }

    private enum GameState {
        DRAW, X_WIN, O_WIN, IMPOSSIBLE, NOT_FINISHED
    }

    private final Cell[][] grid;

    public GameGrid() {
        this.grid = new Cell[][]{
                {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
                {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
                {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY}
        };
    }

    public void fillGrid(String input) {
        if (input.isEmpty()) {
            return;
        }
        for (int i = 0, k = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++, k++) {
                char c = input.charAt(k);
                switch (c) {
                    case 'X' -> grid[i][j] = Cell.X;
                    case 'O' -> grid[i][j] = Cell.O;
                    case '_' -> grid[i][j] = Cell.EMPTY;
                    default -> throw new IllegalArgumentException("Invalid input");
                }
            }
        }
    }

    private GameState stateChecker() {
        boolean x_win = false;
        boolean o_win = false;
        int colCount = 0;
        int rowCount = 0;
        int diagCount = 0;
        int antiDiagCount = 0;
        int totalCount = 0;
        int emptyCount = 9;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                colCount = grid[j][i] == Cell.X ? colCount + 1
                        : grid[j][i] == Cell.O ? colCount - 1 : colCount;
                rowCount = grid[i][j] == Cell.X ? rowCount + 1
                        : grid[i][j] == Cell.O ? rowCount - 1 : rowCount;
                emptyCount = grid[i][j] == Cell.EMPTY ? emptyCount : emptyCount - 1;
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
            return GameState.IMPOSSIBLE;
        } else if (x_win) {
            return GameState.X_WIN;
        } else if (o_win) {
            return GameState.O_WIN;
        } else if (emptyCount == 0) {
            return GameState.DRAW;
        } else {
            return GameState.NOT_FINISHED;
        }
    }

    public String getState() {
        GameState state = stateChecker();
        return switch (state) {
            case IMPOSSIBLE -> "Impossible";
            case X_WIN -> "X wins";
            case O_WIN -> "O wins";
            case DRAW -> "Draw";
            case NOT_FINISHED -> "Game not Finished";
        };
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
    public Cell getCell(int row, int col) {
        return grid[row][col];
    }
    public void setCell(int row, int col, Cell player) {
        grid[row][col] = player == Cell.X ? Cell.X : Cell.O;
    }
}