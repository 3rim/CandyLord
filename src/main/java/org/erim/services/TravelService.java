package org.erim.services;

import org.erim.entities.City;
import org.erim.entities.Player;
import org.erim.enums.Location;
import org.erim.exceptions.NoMoneyException;
import org.erim.exceptions.TravelSameLocationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelService {

    private Map<Location,Integer> travelPrices = new HashMap<>();

    public Map<Location, Integer> calcPrices(Location currentLocation) {
        Map<Location, Integer> result = new HashMap<>();
        for (Location city : Location.values()) {
            int distance = (int) currentLocation.distanceTo(city);

            if(distance == 0){
                result.put(city,0);
            } else if (distance <= 5) {
                int SHORT_DISTANCE = 13;
                result.put(city, SHORT_DISTANCE);
            }else if (distance <= 15) {
                int MIDDLE_DISTANCE = 25;
                result.put(city, MIDDLE_DISTANCE);
            }else if (distance > 20) {
                int LONG_DISTANCE = 36;
                result.put(city, LONG_DISTANCE);
            }
        }
        return result;
    }

    public void travel(Player player, Location city, List<City> cities) {
        int cost = travelPrices.get(city);
        if(player.getCash() < cost){
            throw new NoMoneyException("Player has not enough money");
        } else if (city == player.getCurrentCity().getLocation()) {
            throw new TravelSameLocationException("Cannot travel to same location");
        }

        for (City c : cities) {
            if (c.getLocation() == city){
                player.setCurrentCity(c);
            }
        }

        int playerCurrentCash = player.getCash();
        player.setCash(playerCurrentCash - cost);
    }

    public Map<Location, Integer> getPrices() {
        return travelPrices;
    }
}
