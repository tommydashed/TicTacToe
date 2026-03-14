package io.github.tommydashed.tictactoe;

import java.util.Scanner;

public class GameService {
    private static final Scanner input = new Scanner(System.in);
    private final Game game;

    public GameService(Game game) {
        this.game = game;
    }

    public void play() {
        game.loadBoard(input.nextLine().strip().toUpperCase());
        System.out.println(game.getBoard());
        System.out.println(game.getState());
        input.close();
    }
}
