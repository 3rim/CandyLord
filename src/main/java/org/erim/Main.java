package org.erim;

import org.erim.controller.GameController;
import org.erim.entities.Game;
import org.erim.services.GameService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Candy choco = Candy.CHOCOLATE;
//        System.out.println(choco.getRandomPriceMinMax());
//        System.out.println(choco.getRandomPriceMinMax());
//        System.out.println(choco.getRandomPriceMinMax());
//
//        Game game = new Game();
//        Candy c = Candy.COTTON_CANDY;
//
//        System.out.println(game.getCandies());
//        game.getCandies().forEach(candy -> {
//            System.out.println(choco.getRandomPriceMinMax());
//        });

         /* LocalDate date = LocalDate.now();

        String formattedDate = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String location = "Miami";
        String hold = "5";
        System.out.println("╒═══════════════════════════════════════════════════════════════════════════╕");
        System.out.println("│                       *** CANDY LORD ***                                  │ ");
        System.out.println("╞════ Date: " + formattedDate + " ════════════════════╤════════════════════════════════│ ");
        System.out.println("│                                          │ Location: "+location+"                  │ ");
        System.out.println("╞════ Drugs on Hand:═══╤════ Street Prices ╪ Hold: "+hold+" ════════════════════════│ ");
        System.out.println("│                                                               │ ");*/


        GameService gameService = new GameService();
        CommandLineGUI gui = new CommandLineGUI();
        GameController gameController = new GameController(gameService,gui);
        Game game = gameService.newGame();

        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        gui.renderMain(game);
        while(gameRunning){
            String input = scanner.next();
            switch (input){
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
