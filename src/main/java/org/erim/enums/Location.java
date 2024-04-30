package org.erim.enums;

import java.awt.*;
import java.util.Map;

public enum Location {
    BRONX(new Point(0,0)),
    GHETTO(new Point(0,5)),
    CENTRAL_PARK(new Point(0,10)),
    MANHATTAN(new Point(0,15)),
    CONEY_ISLAND(new Point(0,20)),
    BROOKLYN(new Point(0,25));

    private final Point location;
    Location(Point point){
        this.location = point;
    }

    public Point getLocation() {
        return location;
    }

    public double distanceTo(Location other){
        return this.location.distance(other.location);
    }
}
