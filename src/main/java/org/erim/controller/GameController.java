package org.erim.controller;

import org.erim.CommandLineGUI;
import org.erim.entities.Game;
import org.erim.enums.Candy;
import org.erim.enums.Location;
import org.erim.exceptions.CanNotSellCandyException;
import org.erim.exceptions.CandyCapacityException;
import org.erim.exceptions.NoMoneyException;
import org.erim.services.GameService;

import java.util.Map;

public class GameController {


    private final GameService gameService;
    private final CommandLineGUI gui;

    public GameController(GameService gameService, CommandLineGUI gui) {
        this.gameService = gameService;
        this.gui = gui;
    }

    public Map<Location, Integer> jet() {
        return gameService.getTravelCosts();
    }

    public void candyOptions() {
        gui.renderCandyOptions(gameService.getGameData().getCandies());
        /*Scanner scanner = new Scanner(System.in);
        int candyType = scanner.nextInt();
        System.out.println("How many?"); //Vermischung von Verantwortlichkeiten? SysOut hier??
        int amount = scanner.nextInt();

        buyCandy(candyType,amount);*/
    }

    public void buyCandy(int candyType, int amount) {
        Candy candy = Candy.values()[candyType];
        try {
            Game data = gameService.buyCandy(candy, amount);
            gui.renderMain(data);
        } catch (NoMoneyException | CandyCapacityException e) {
            gui.renderErrMsg(e.getMessage(), gameService.getGameData());
        }
    }

    public void sellCandy(int candyType, int amount) {
        Candy candy = Candy.values()[candyType];
        try {
            Game data = gameService.sellCandy(candy, amount);
            gui.renderMain(data);
        } catch (CanNotSellCandyException e) {
            gui.renderErrMsg(e.getMessage(), gameService.getGameData());
        }
    }

    public void bank() {
    }

    public void loan() {
    }

    public void jetOptions() {
        gui.renderCityOptions(gameService.getTravelCosts());
    }

    public void travelTo(int destination) {
        try {
            Location location = Location.values()[destination];
            Game data = gameService.travelTo(location);
            gui.renderMain(data);
        } catch (NoMoneyException e) {
            gui.renderErrMsg(e.getMessage(), gameService.getGameData());
        }
    }
}
