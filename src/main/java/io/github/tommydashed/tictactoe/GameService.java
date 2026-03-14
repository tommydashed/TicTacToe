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
        String board = input.nextLine().strip().toUpperCase();
        game.loadBoard(board);
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
        input.close();
    }
}
