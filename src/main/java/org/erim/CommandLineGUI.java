package org.erim;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import org.erim.entities.*;
import org.erim.enums.Candy;
import org.erim.enums.Location;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CommandLineGUI {
    AsciiTable main;

    private final String LINE_BREAK = "<br/>";

    public CommandLineGUI() {
        // Candy: amount <br>
        main = new AsciiTable();
    }

    public void renderGameData(Game gameData) {
        main = new AsciiTable();
        main.addRule();
        AT_Row header = main.addRow(null, null, "* * * Candy Lord * * *");
        header.setTextAlignment(TextAlignment.CENTER);
        main.addRule();
        AT_Row stats = main.addRow(null, "Date:"+gameData.getDate(), "Location:" + printPlayerLocation(gameData));
        stats.setTextAlignment(TextAlignment.CENTER);
        main.addRule();
        AT_Row third = main.addRow("Candy on Hand", "Street Prices", "Player Stats");
        main.addRule();
        AT_Row lists = main.addRow(printPlayerCandy(gameData), printStreetPrices(gameData), printPlayerStats(gameData));
        main.addRule();

        System.out.println(main.render());
    }


    private String printPlayerLocation(Game gameData) {
        return gameData.getPlayer().getCurrentCity().getLocation().toString();
    }

    public void renderMainActions() {
        System.out.println("What do you wanna do?");
        System.out.println("(B)uy Drugs - (S)ell Drugs - (J)et to other city");
    }

    public void renderCandyOptions(List<Candy> candyList) {
        candyList.forEach(candy -> {
            System.out.printf("%d.%s || ",candy.ordinal(),candy);
        });
        System.out.println();
    }

    public void renderMain(Game game) {
        renderGameData(game);
        renderMainActions();
    }

    private String printStreetPrices(Game gameData) {
        City city = gameData.getPlayer().getCurrentCity();
        StringBuilder stringBuilder = new StringBuilder();
        city.getBlackMarketList().forEach((candy, integer) -> {
            stringBuilder.append(candy).append(":").append(integer).append(LINE_BREAK);
        });
        return stringBuilder.toString();
    }

    private String printPlayerCandy(Game gameData) {
        Map<Candy, Integer> candies = gameData.getPlayer().getCandies();
        StringBuilder stringBuilder = new StringBuilder();
        candies.forEach((candy, integer) -> {
            stringBuilder.append(candy).append(":").append(integer).append(LINE_BREAK);
        });
        return stringBuilder.toString();
    }

    private String printPlayerStats(Game gameData) {
        StringBuilder stringBuilder = new StringBuilder();
        Player player = gameData.getPlayer();
        Bank bank = gameData.getBank();
        LoanShark loanShark = gameData.getLoanShark();

        stringBuilder
                .append("Hold:").append(player.getHold()).append(" (max ").append(player.capacity()).append(")").append(LINE_BREAK)
                .append("cash:").append(player.getCash()).append(LINE_BREAK)
                .append("In Bank:").append(bank.getSavings()).append(LINE_BREAK)
                .append("In Debt:").append(loanShark.getDebt()).append(LINE_BREAK)
                .append("Health:").append(player.getHealth());
        return stringBuilder.toString();
    }

    public void renderErrMsg(String msg, Game gameData) {
        System.out.println(msg);

        //Delay re-rendering main Menu
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        renderMain(gameData);
    }

    public void renderCityOptions(Map<Location, Integer> travelCosts) {
        travelCosts.forEach((location , travelCost) ->
                System.out.printf("%d.%s %d$ || ",location.ordinal(),location,travelCost));
        System.out.println();
    }
}
