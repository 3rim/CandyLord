package org.erim.services;

import org.erim.entities.City;
import org.erim.entities.Game;
import org.erim.enums.Candy;
import org.erim.enums.Location;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.Map;

public class GameService {
    private final TravelService travelService;
    private Game game;

    public GameService(){
        this.travelService = new TravelService();
        this.game = new Game();
    }


    public Game newGame(){
        game = new Game();
        return game;
    }

    public Game closeGame(){

        return null;
    }

    public Game nextRound(){
        game.nextRound();
        return game;
    }

    /**
     * The travel costs
     * @return the travel costs from current location to others
     */
    public Map<Location, Integer> getTravelCosts() {
        return travelService.calcPrices(game.getPlayer().getCurrentCity().getLocation());
    }

    public Game travelTo(Location city){
        /*int travelCost = travelCosts.get(city);
        if(game.getPlayer().getCash() < travelCost){
            throw new NoMoneyException("Player has not enough money");
        } else if (city == game.getPlayer().getCurrentCity().getLocation()) {
            throw new TravelSameLocationException("Cannot travel to same location");
        }

        game.getPlayer().setCurrentCity();

        int playerCurrentCash = game.getPlayer().getCash();
        game.getPlayer().setCash(playerCurrentCash - travelCost);
        return game;*/

        travelService.travel(game.getPlayer(),city,game.getCities());
        // Unnötiges shuffeln aller Städte. Eine Stadt wird dann relevant,wenn sie besucht wird.
        game.getCities().forEach(City::shuffleMarket);
        return nextRound();
    }

    public Game getGameData() {
        return game;
    }

    public Game buyCandy(Candy candyType, int amount) {
       game.getPlayer().buyCandy(candyType,amount);
       return game;
    }
    public Game sellCandy(Candy candyType, int amount){
        game.getPlayer().sellCandy(candyType,amount);
        return game;
    }
}
