package io.github.tommydashed.tictactoe;

import java.util.Scanner;

public class Main {
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String gridTxt = Main.input.nextLine().strip().toUpperCase();
        GameGrid grid = new GameGrid(gridTxt);
        System.out.println("-".repeat(9));
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid.grid[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-".repeat(9));
        System.out.println(grid.state);
    }
}


