package org.erim.entities;

import org.erim.enums.Candy;
import org.erim.enums.City;
import org.erim.enums.Overcoat;

import java.util.List;
import java.util.Map;

public class Player {
    private int health,cash;
    private Map<Candy,Integer> candies;
    private Overcoat overcoat;
    private City currentLocation;

    private List<Weapons> weapons;
}
