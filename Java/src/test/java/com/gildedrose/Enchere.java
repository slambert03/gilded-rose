package com.gildedrose;

public class Enchere {
    private double price;
    private item item;
    private int count;
    private Shop shop;

    public Enchere(item item, Shop shop){
        this.shop = shop;
        this.item = item;
        this.count = 0;
        this.price = item.getValue();
    }

    public void newEnchere(){
       count++;
       if (count == 3) {
           this.price += (this.price / 100) * 10;
           this.shop.sellItem(this.item.getType(), this.item.getQuality());
           return ;
       }
       if (count > 3)
           return ;
       this.price += (this.price / 100 ) * 10;
    }

    public double getPrice(){
        return this.price;
    }
}
