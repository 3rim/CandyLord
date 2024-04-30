package org.erim;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import org.erim.controller.GameController;
import org.erim.entities.Game;
import org.erim.enums.Candy;
import org.erim.services.GameService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        GameService gameService = new GameService();
        CommandLineGUI gui = new CommandLineGUI();
        GameController gameController = new GameController(gameService,gui);

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


        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;



        while(gameRunning){
            printGUI();
            String input = scanner.next();
            switch (input){
                case "b" -> gameController.buy();
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
