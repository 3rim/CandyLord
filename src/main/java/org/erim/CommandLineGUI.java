package org.erim;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import org.erim.entities.City;
import org.erim.entities.Game;
import org.erim.enums.Candy;

import java.util.Map;

public class CommandLineGUI {

    AsciiTable main;
    public CommandLineGUI(){

        // Candy: amount <br>
        main = new AsciiTable();

    }

    public void renderMain(Game gameData){
        main = new AsciiTable();
        main.addRule();
        AT_Row header = main.addRow(null,null, "* * * Candy Lord * * *");
        header.setTextAlignment(TextAlignment.CENTER);
        main.addRule();
        AT_Row stats = main.addRow(null,"", "Stats");
        stats.setTextAlignment(TextAlignment.CENTER);
        main.addRule();
        AT_Row third = main.addRow("Candy on Hand","Street Prices", "");
        main.addRule();
        AT_Row lists = main.addRow(printPlayerCandy(gameData),printStreetPrices(gameData),"");

        System.out.println(main.render());
        //main.render();
    }

    private String printStreetPrices(Game gameData) {
        City city = gameData.getPlayer().getCurrentCity();
        System.out.println(city.getLocation());
        System.out.println(city.getBlackMarketList());
        StringBuilder stringBuilder = new StringBuilder();
        city.getBlackMarketList().forEach((candy, integer) -> {
            stringBuilder.append(candy).append(":").append(integer).append("<br>");
        });
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

    private String printPlayerCandy(Game gameData) {
        Map<Candy, Integer> candies = gameData.getPlayer().getCandies();
        StringBuilder stringBuilder = new StringBuilder();
        candies.forEach((candy, integer) -> {
            stringBuilder.append(candy).append(":").append(integer).append("<br>");
        });
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public void renderBuy() {

        System.out.println("buy options");
    }
}
