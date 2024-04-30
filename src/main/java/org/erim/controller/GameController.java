package org.erim.controller;

import org.erim.CommandLineGUI;
import org.erim.enums.Location;
import org.erim.services.GameService;

import java.util.Map;
import java.util.Scanner;

public class GameController {


    private final GameService gameService;
    private final CommandLineGUI gui;

    public GameController(GameService gameService, CommandLineGUI gui) {
        this.gameService = gameService;
        this.gui = gui;
    }

    public Map<Location, Integer> jet(){
         return gameService.getTravelCosts();
    }

    public void buy() {
        gui.renderMain(gameService.getGameData());
        gui.renderBuy();
        Scanner scanner = new Scanner(System.in);
    }

    public void sell() {
    }

    public void bank() {
    }

    public void loan() {
    }
}
