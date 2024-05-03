package org.erim.entities;

import org.erim.enums.Candy;
import org.erim.enums.Location;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Game {

    private final Player player;
    private final LoanShark loanShark;
    private final Bank bank;
    private LocalDate date;
    private final List<Candy> candies;
    private final List<City> cities;

    public Game() {
        //init cities
        cities = new ArrayList<>();
        Arrays.stream(Location.values()).forEach(location -> cities.add(new City(location)));
        cities.sort(Comparator.comparingInt(o -> o.getLocation().ordinal()));

        player = new Player(cities.getFirst());
        loanShark = new LoanShark();
        bank = new Bank();
        date = LocalDate.now();
        candies = Arrays.stream(Candy.values()).toList();
    }

    public Player getPlayer() {
        return player;
    }

    public LoanShark getLoanShark() {
        return loanShark;
    }

    public Bank getBank() {
        return bank;
    }

    public List<City> getCities() {
        return cities;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Candy> getCandies() {
        return candies;
    }

    public void nextRound(){
        date = date.plusDays(1);
    }

}
