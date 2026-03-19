package io.github.tommydashed.tictactoe.cli;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public int readInt() throws NumberFormatException {
        return Integer.parseInt(scanner.next());
    }
}
