package org.example;

public class DisplayBalanceAction extends ActionsConsole {
    public DisplayBalanceAction(Shop shop) {
        super();
    }

    public void action(){
        System.out.println("Vous avez demandé de voir le solde, il est à actuellement "+this.shop.balance+" unités");
    }
}

