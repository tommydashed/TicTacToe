package io.github.tommydashed.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameService {
    private static final Scanner input = new Scanner(System.in);
    private final Game game;

    public GameService(Game game) {
        this.game = game;
    }

    public void play() {
        GameState state = game.state();

        while (state == GameState.NOT_FINISHED) {
            game.clearScreen();
            System.out.println(game.getBoard());

            int firstCoordinate;
            int secondCoordinate;
            while (true) {
                try {
                    firstCoordinate = input.nextInt();
                    secondCoordinate = input.nextInt();
                    if (firstCoordinate < 1 || firstCoordinate > 3 || secondCoordinate < 1 || secondCoordinate > 3) {
                        throw new IllegalArgumentException();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("You should enter numbers!");
                    input.nextLine();
                    continue;
                } catch (IllegalArgumentException e) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                try {
                    game.makeMove(firstCoordinate, secondCoordinate);
                    System.out.println(game.getBoard());
                } catch (IllegalArgumentException e) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                break;
            }
            state = game.state();
            game.switchPlayer();
        }
        game.clearScreen();
        System.out.println(game.getBoard());
        if (state == GameState.DRAW) {
            System.out.println("It's a draw!");
        }
        else if (state == GameState.X_WIN) {
            System.out.println("X wins!");
        }
        else if (state == GameState.O_WIN) {
            System.out.println("O wins!");
        }
        else {
            System.out.println("Impossible!");
        }
        input.close();
    }
}
