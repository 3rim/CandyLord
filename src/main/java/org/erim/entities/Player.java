package org.erim.entities;

import org.erim.enums.Candy;
import org.erim.enums.Location;
import org.erim.enums.Overcoat;
import org.erim.exceptions.CandyCapacityException;
import org.erim.exceptions.NoMoneyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private int health, cash;
    private Map<Candy, Integer> candies;

    //Maximum storing size for candies - depends on coat ype
    private Overcoat overcoat;
    private City currentLocation;

    private List<Weapons> weapons;

    public Player(City city) {
        health = 100;
        cash = 100;
        overcoat = Overcoat.STANDARD;
        weapons = new ArrayList<>();
        currentLocation = city;
        candies = new HashMap<>();
        for (Candy value : Candy.values()) {
            candies.put(value, 0);
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public Map<Candy, Integer> getCandies() {
        return candies;
    }

    public void setCandies(Map<Candy, Integer> candies) {
        this.candies = candies;
    }


    public Overcoat getOvercoat() {
        return overcoat;
    }

    public void setOvercoat(Overcoat overcoat) {
        this.overcoat = overcoat;
    }

    public City getCurrentCity() {
        return currentLocation;
    }


    /**
     * Current Hold of the player
     *
     * @return the current hold
     */
    public int getHold() {
        // Sum all the integer values using Java 8 Streams
        return candies.values().stream().mapToInt(Integer::intValue).sum();
    }

    public void setCurrentCity(City newLocation) {
        this.currentLocation = newLocation;
    }

    public List<Weapons> getWeapons() {
        return weapons;
    }

    public void addWeapon(Weapons weapon) {
        weapons.add(weapon);
    }

    /**
     * Candy-Capacity which the player can hold
     *
     * @return capacity of the current Coat
     */
    public int capacity() {
        return overcoat.getCapacity();
    }

    public void buyCandy(Candy candyType, int amount) {
        int candyPrice = this.currentLocation.getBlackMarketList().get(candyType);
        int totalCosts = amount * candyPrice;
        if (cash < (totalCosts))
            throw new NoMoneyException("Not enough money");
        if ((amount +getHold()) > overcoat.getCapacity())
            throw new CandyCapacityException("Cant hold more Candies. Buy a bigger Coat");
        else{
            cash -= totalCosts;
            int currentAmountCandy = candies.get(candyType);
            candies.replace(candyType,amount+currentAmountCandy);
        }
    }


    //TODO: getWeapon(Weapon weapon)
}

