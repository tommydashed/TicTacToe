package io.github.tommydashed.tictactoe;

public class GameGrid {
    private enum Cell {
        EMPTY, X, O
    }

    private enum GameState {
        DRAW, X_WIN, O_WIN, IMPOSSIBLE, NOT_FINISHED
    }

    String[][] grid;
    String state;

    public GameGrid(String gridTxt) {
        this.grid = new String[3][3];
        gridGenerator(gridTxt);
        setState();
    }

    private void gridGenerator(String gridTxt) {
        for (int i = 0, k = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++, k++) {
                grid[i][j] = String.valueOf(gridTxt.charAt(k));
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
                colCount = grid[j][i].equals("X") ? colCount + 1
                        : grid[j][i].equals("O") ? colCount - 1 : colCount;
                rowCount = grid[i][j].equals("X") ? rowCount + 1
                        : grid[i][j].equals("O") ? rowCount - 1 : rowCount;
                emptyCount = grid[i][j].equals("_") ? emptyCount : emptyCount - 1;
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
            diagCount = grid[i][i].equals("X") ? diagCount + 1
                    : grid[i][i].equals("O") ? diagCount - 1 : diagCount;
            if (diagCount == 3) {
                x_win = true;
            }
            if (diagCount == -3) {
                o_win = true;
            }
            antiDiagCount = grid[i][j].equals("X") ? antiDiagCount + 1
                    : grid[i][j].equals("O") ? antiDiagCount - 1 : antiDiagCount;
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
    private void setState() {
        this.state = switch(stateChecker()) {
            case GameState.IMPOSSIBLE -> "Impossible";
            case GameState.X_WIN -> "X wins";
            case GameState.O_WIN -> "O wins";
            case GameState.DRAW -> "Draw";
            case GameState.NOT_FINISHED -> "Game not finished";
        };
    }
}

