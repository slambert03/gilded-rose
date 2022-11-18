package org.example;

public class SeeAllArticlesAction extends ActionsConsole {
    public SeeAllArticlesAction(Shop shop) {
        this.shop = shop;
    }

    public void action() {
        item[] allItems = this.shop.getItems();
        item actualItem;
        for (int indice = 0; indice < allItems.length; indice++) {
            actualItem = allItems[indice];
            System.out.println(actualItem.toString2());
        }
    }
}
