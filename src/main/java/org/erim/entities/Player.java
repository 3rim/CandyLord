package org.erim.entities;

import org.erim.enums.Candy;
import org.erim.enums.Location;
import org.erim.enums.Overcoat;

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
        cash = 0;
        overcoat = Overcoat.STANDARD;
        weapons = new ArrayList<>();
        currentLocation = city;
        candies = new HashMap<>();
        for (Candy value : Candy.values()) {
            candies.put(value,0);
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


    //TODO: getWeapon(Weapon weapon)
}

