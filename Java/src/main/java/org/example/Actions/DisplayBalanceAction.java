package org.example.Actions;

import org.example.Shop.*;

public class DisplayBalanceAction extends ActionsConsole {
    public DisplayBalanceAction(Shop shop) {
        this.shop = shop;
    }

    public float getBalance() {
        return this.shop.balance;
    }

    public void action() {
        System.out
                .println("Vous avez demandé de voir le solde, il est à actuellement " + this.shop.balance + " unités");
    }
}
