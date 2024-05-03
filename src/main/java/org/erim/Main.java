package org.erim;

import org.erim.controller.GameController;
import org.erim.entities.Game;
import org.erim.services.GameService;

import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        CommandLineGUI gui = new CommandLineGUI();
        GameController gameController = new GameController(gameService, gui);
        Game game = gameService.newGame();

        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        gui.renderMain(game);
        while (gameRunning) {
            String input = scanner.next();
            switch (input.toLowerCase()) {
                case "b" -> {
                    System.out.println("What do you wanna BUY?");
                    gameController.candyOptions();

                    int candyType = scanner.nextInt();
                    System.out.println("How many?");
                    int amount = scanner.nextInt();

                    gameController.buyCandy(candyType, amount);
                }
                case "s" -> {
                    System.out.println("What do you wanna SELl ?");
                    gameController.candyOptions();

                    int candyType = scanner.nextInt();
                    System.out.println("How many?");
                    int amount = scanner.nextInt();

                    gameController.sellCandy(candyType, amount);

                }
                case "j" -> {
                    System.out.println("Where do you wanna travel?");
                    gameController.jetOptions();
                    int destination = scanner.nextInt();
                    gameController.travelTo(destination);
                }
                case "v" -> gameController.bank();
                case "l" -> gameController.loan();
                default -> System.out.println("could not read input");
            }
        }
    }

    private static void printGUI() {
    }
}
