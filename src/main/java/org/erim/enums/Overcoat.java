package org.erim.enums;

public enum Overcoat {
    STANDARD(10),
    DOUBLE(20),
    TRIPLE(30),
    DEALER(50);

    private final int capacity;

    Overcoat(int storingSize) {this.capacity = storingSize;}


    public int getCapacity() {
        return capacity;
    }
}
