package org.example;

import java.util.ArrayList;

public class BuyerAuction {
    private String BuyerName;
    private float BuyerBalanceToPay;
    private ArrayList<AuctionItem> ItemsToPayByAuction = new ArrayList<>();

    public BuyerAuction(String name) {
        this.BuyerName = name;
        this.BuyerBalanceToPay = 0;
    }

    public void AddAnAuctionItemToPay(AuctionItem itemToPay) {
        this.ItemsToPayByAuction.add(itemToPay);
        this.BuyerBalanceToPay += itemToPay.getAuctionPrice();
    }

    public String getName() {
        return this.BuyerName;
    }

    public float getBalanceToPay() {
        return this.BuyerBalanceToPay;
    }

}
