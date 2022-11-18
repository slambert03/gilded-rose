package org.example.Actions;

import org.example.Items.*;

import org.example.Shop.*;

public class EndOfDayAction extends ActionsConsole {
    public EndOfDayAction(Shop shop) {
        this.shop = shop;
    }

    public void action() {
        item[] allItems = this.shop.getItems();
        item actualitem;
        for (int indice = 0; indice < allItems.length; indice++) {
            actualitem = allItems[indice];
            actualitem.updateQuality();
            actualitem.updateSellin();
        }

        System.out.println("tous les items ont bien été mis à jour");
    }
}
