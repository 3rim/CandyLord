package org.erim.entities;

import org.erim.enums.Candy;
import org.erim.enums.Location;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private Player player;
    private LoanShark loanShark;
    private Bank bank;
    private LocalDate date;
    private List<Candy> candies;
    private List<City> cities;

    public Game() {
        //init cities
        cities = new ArrayList<>();
        Arrays.stream(Location.values()).forEach(location -> cities.add(new City(location)));

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
}
