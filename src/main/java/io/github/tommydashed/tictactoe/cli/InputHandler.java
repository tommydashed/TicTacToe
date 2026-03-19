package io.github.tommydashed.tictactoe.cli;

import io.github.tommydashed.tictactoe.core.Move;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public int readInt() throws NumberFormatException {
        return Integer.parseInt(scanner.next());
    }
    public Move readMove() {
        return new Move(readInt(), readInt());
    }
}
