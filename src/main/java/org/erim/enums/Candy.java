package org.erim.enums;

import java.util.concurrent.ThreadLocalRandom;

public enum Candy {
    CARAMELS(1,5),
    GUMMY(12,20),
    LICORICE(25,35),
    LOLLIPOP(36,50),
    CHEWING_GUM(60,100),
    COTTON_CANDY(120,150),
    CHOCOLATE(170,220);

    private final int minPrice;
    private final int maxPrice;

    //private int currentPrice;
    Candy(int min, int max) {
        this.minPrice = min;
        this.maxPrice = max;
        //currentPrice = getRandomPriceMinMax();
    }

    public int getRandomPriceMinMax(){
        return ThreadLocalRandom.current().nextInt(minPrice,maxPrice +1);
    }

   /* public int getCurrentPrice() {
        return currentPrice;
    }*/
}
