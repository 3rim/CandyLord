package org.erim.entities;

import org.erim.enums.Candy;
import org.erim.enums.Location;

import java.util.HashMap;
import java.util.Map;

public class City {

    private final Location location;
    private Map<Candy,Integer>blackMarketList = new HashMap<>();

    public City(Location city){
        shuffleMarket();
        this.location = city;
    }

    public void setBlackMarketList(Map<Candy, Integer> blackMarketList) {
        this.blackMarketList = blackMarketList;
    }

    public Location getLocation() {
        return location;
    }

    public Map<Candy, Integer> getBlackMarketList() {
        return blackMarketList;
    }

    public void shuffleMarket(){
        for (Candy value : Candy.values()) {
            this.blackMarketList.put(value,value.getRandomPriceMinMax());
        }
    }
}
