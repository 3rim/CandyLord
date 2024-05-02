package org.erim;

import org.erim.controller.GameController;
import org.erim.entities.Game;
import org.erim.services.GameService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        CommandLineGUI gui = new CommandLineGUI();
        GameController gameController = new GameController(gameService,gui);
        Game game = gameService.newGame();

        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        gui.renderMain(game);
        while(gameRunning){
            String input = scanner.next();
            switch (input.toLowerCase()){
                case "b" -> gameController.buyOptions();
                case "s" -> gameController.sell();
                case "j" -> gameController.jet();
                case "v" -> gameController.bank();
                case "l" -> gameController.loan();
            }
        }
    }

    private static void printGUI() {
    }
}
