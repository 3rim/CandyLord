package org.erim.services;

import org.erim.entities.Game;
import org.erim.enums.Candy;
import org.erim.enums.Location;

import java.util.HashMap;
import java.util.Map;

public class GameService {
    private TravelService travelService;
    private Game game;
    private Map<Candy,Integer> candyPrices;
    private Map<Location,Integer> travelCosts;

    public GameService(){
        this.travelService = new TravelService();
        this.game = new Game();
        this.candyPrices = new HashMap<>();
        this.travelCosts = new HashMap<>();
    }

    public Game newGame(){
        //TODO:

        return null;
    }

    public Game closeGame(){

        return null;
    }

    public Game nextRound(){

        return null;
    }

    /**
     * The travel costs
     * @return the travel costs from current location to others
     */
    public Map<Location, Integer> getTravelCosts() {
        return travelService.getPrices();
    }

    public void travelTo(Location city){
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

    }

    public Game getGameData() {
        return game;
    }
}
