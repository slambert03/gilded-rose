package org.example;

public class ActionsConsole {
    protected Shop shop;

    public ActionsConsole getAction(String toDo, Shop shop) {
        this.shop = shop;
        if (toDo.charAt(0) == '1') {
            return new DisplayBalanceAction(shop);
        } else if (toDo.charAt(0) == '2') {
            return new SellAnArticleAction(shop);
        } else if (toDo.charAt(0) == '3') {
            return new SeeAllArticlesAction(shop);
        } else if (toDo.charAt(0) == '4') {
            return new EndOfDayAction(shop);
        } else if (toDo.charAt(0) == '5') {
            return new AuctionHouse(shop);
        }

        else {
            System.out.println("le code entré n'est pas reconnu");
            return null;
        }
    }

    public void action() {
        // TODO
    }
}
